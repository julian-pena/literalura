package com.aluralearning.literalura.service;

import com.aluralearning.literalura.dtos.AuthorDTO;
import com.aluralearning.literalura.dtos.BookDTO;
import com.aluralearning.literalura.entities.Author;
import com.aluralearning.literalura.entities.Book;
import com.aluralearning.literalura.repository.AuthorRepository;
import com.aluralearning.literalura.repository.BookRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import static java.net.http.HttpClient.Redirect;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .followRedirects(Redirect.ALWAYS)
            .build();
    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    //--> Get book by name from API<--\\
    @Transactional
    public void getBookByName(String name) throws IOException, InterruptedException {
        HttpResponse<String> response = getResponseFromApi(name);
        if(response == null) return;

        // Parse the response to get the first book in the results
        JsonNode rootNode = OBJECT_MAPPER.readTree(response.body());
        JsonNode resultsNode = rootNode.path("results");
        // Check if there is a result
        if (resultsNode.isArray() && resultsNode.size() > 0) {
            // Get first book found
            JsonNode firstBookNode = resultsNode.get(0);
            // Extract the author details
            JsonNode authorsNode = firstBookNode.path("authors");
            if (authorsNode.isArray() && authorsNode.size() > 0) {
                Author author = OBJECT_MAPPER.treeToValue(authorsNode.get(0), Author.class);

                // Retrieve the author from the database (if it exists)
                Optional<Author> existingAuthor = authorRepository.findByName(author.getName());
                // Set existing author to book
                if (existingAuthor.isPresent())  author = existingAuthor.get();

                // Retrieve the book from the database (if it exists)
                Optional<Book> existingBook = bookRepository.findByTitle(firstBookNode.path("title").asText());
                // Inform user that book already exists and to try a different name
                if(existingBook.isPresent()) {
                    System.out.printf("\nBook %s already exists in database. Please save a new book\n", firstBookNode.path("title").asText());
                    return;
                }
                // Create BookDTO instance
                Book foundBook = new Book(
                        firstBookNode.path("title").asText(),
                        author,
                        OBJECT_MAPPER.convertValue(firstBookNode.path("languages"), List.class),
                        firstBookNode.path("download_count").asLong()
                );
                // Convert entity to DTO to display to user
                BookDTO bookDTO = OBJECT_MAPPER.convertValue(foundBook, BookDTO.class);
                // Show BookDTO to user
                System.out.println(bookDTO);
                // Persist the book to the database
                bookRepository.save(foundBook);
                System.out.println("\n--->Book added<---\n");
            }
        }
        // No result was found in API with that book name
        else System.out.printf("\nNo result found with %s. Please try a different name\n", name);
    }

    public void getBooksInDatabase(){
       List<Book> bookList = bookRepository.findAll();
       if(bookList.isEmpty()) System.out.println("\nNo books found in database. Enter a new book");
       else mapToBookDTO(bookList).forEach(System.out::println);
    }

    public void getAuthorsInDatabase(){
        List<Author> authorList = authorRepository.findAll();
        if(authorList.isEmpty()) System.out.println("\nNo authors found in database. Enter a new book so a new author is added");
        else mapToAuthorDTO(authorList).forEach(System.out::println);
    }

    public void getAuthorsByYear(int year) {
        List<Author> authorList = authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
        if(authorList.isEmpty()) System.out.printf("\nNo authors alive in %d in database\n", year);
        else mapToAuthorDTO(authorList).forEach(System.out::println);
    }

    public void getBooksByLanguage(String language){
        List<Book> bookList = bookRepository.findByLanguages(language);
        if(bookList.isEmpty()) System.out.printf("\nNo books found in language %s\n", language);
        else mapToBookDTO(bookList).forEach(System.out::println);
    }

    private HttpResponse<String> getResponseFromApi(String name) throws IOException, InterruptedException {
        // Build the GET request using search parameter
        String baseUrl = "https://gutendex.com/books/?search=";
        String url = baseUrl + name.replaceAll(" ", "%20");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send the request and get the response
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        // Check if response is empty
        if (response.body().isEmpty()) {
            System.out.println("\nResponse body is empty.");
            return null;
        }

        // Check for successful response
        if (response.statusCode() != 200) {
            System.out.println("\nError retrieving data: Status code " + response.statusCode());
            return null;
        }
        return response;
    }

    private List<BookDTO> mapToBookDTO(List<Book> books){
         return books.stream()
                .map(b -> OBJECT_MAPPER.convertValue(b, BookDTO.class))
                .toList();
    }

    private List<AuthorDTO> mapToAuthorDTO(List<Author> authorList) {
        return authorList.stream()
                .map(author -> new AuthorDTO(
                        author.getName(),
                        author.getBirthYear(),
                        author.getDeathYear(),
                        bookRepository.findTitlesByAuthorId(author.getId())
                ))
                .toList();
    }

}