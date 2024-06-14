package com.aluralearning.literalura.repository;

import com.aluralearning.literalura.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByTitle(String name);
    @Query(value = "SELECT b.title FROM Book b WHERE b.author.id = :authorId")
    List<String> findTitlesByAuthorId(@Param("authorId") Long authorId);
    @Query(value = "SELECT * FROM books b WHERE :language = ANY(b.languages)", nativeQuery = true)
    List<Book> findByLanguages(@Param("language") String language);
}
