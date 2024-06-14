package com.aluralearning.literalura.repository;

import com.aluralearning.literalura.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(int year, int anotherYear);
}

