package com.aluralearning.literalura.view;

import com.aluralearning.literalura.dtos.AuthorDTO;
import com.aluralearning.literalura.dtos.BookDTO;
import com.aluralearning.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class Menu {
    private static BookService bookService;
    @Autowired
    public Menu(BookService theBookService){
        bookService = theBookService;
    }


    public void showMenu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMainMenu();
            choice = readInt(scanner);

            switch (choice) {
                case 1 -> searchBook(scanner);
                case 2 -> listSearchedBooks();
                case 3 -> listSearchedAuthors();
                case 4 -> listAuthorsAliveInPeriod(scanner);
                case 5 -> listBooksByLanguage(scanner);
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("\nInvalid choice, please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("\n--->> Main Menu <<---");
        System.out.println("1- Search a book");
        System.out.println("2- List searched books");
        System.out.println("3- List searched authors");
        System.out.println("4- List authors alive in a certain period");
        System.out.println("5- List books by language");
        System.out.println("0- Exit");
        System.out.print("\nChoose an option: ");
    }

    private void searchBook(Scanner scanner) throws IOException, InterruptedException {
        System.out.print("\nEnter book title: ");
        String bookTitle = scanner.nextLine();
        bookService.getBookByName(bookTitle);
    }

    private void listSearchedBooks() {
        bookService.getBooksInDatabase();
    }

    private void listSearchedAuthors() {
        bookService.getAuthorsInDatabase();
    }

    private void listAuthorsAliveInPeriod(Scanner scanner) {
        System.out.println("\nEnter year to search for authors alive in that year");
        int yearToSearch = readInt(scanner);
        bookService.getAuthorsByYear(yearToSearch);
    }

    private void listBooksByLanguage(Scanner scanner) {
        String languageChoice;
        printLanguageMenu();
        languageChoice = scanner.nextLine();
        bookService.getBooksByLanguage(languageChoice);
    }

    private void printLanguageMenu() {
        System.out.println("\nEnter language code to search books in that language\n");
        System.out.println("          -->Language code examples<---");
        System.out.println("EN - English   ES - Spanish   FR - French");
        System.out.println("PT - Portuguese    DE - German   RU - Russian");
        System.out.println("JA - Japanese   ZH - Chinese   HI - Hindi");
    }

    private int readInt(Scanner scanner){
        int valueInputted = -1;
        try{
            valueInputted = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nInvalid input for integer value. Please enter a valid number.");
        }
        scanner.nextLine(); // consume newline
        return valueInputted;
    }

}
