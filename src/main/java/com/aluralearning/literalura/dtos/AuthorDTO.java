package com.aluralearning.literalura.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.StringJoiner;

public record AuthorDTO(String name,
                        @JsonProperty("birth_year")
                        int birthYear,
                        @JsonProperty("death_year")
                        int deathYear,
                        @JsonProperty("bookList")
                        List<String> bookList) {

    @Override
    public String toString(){
        StringJoiner booksString = new StringJoiner(" || ", "{", "}");
        bookList.forEach(booksString::add);
        return "----- Author -----\n" +
            "Author: " + name +
            "\nBirth Year: " + birthYear +
            "\nDeath Year: " + deathYear +
            "\nBooks: " + booksString + "\n" +
            "-------------";
    }
}
