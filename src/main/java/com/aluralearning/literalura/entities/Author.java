package com.aluralearning.literalura.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    @Column(unique = true)
    private String name;
    @JsonProperty("birth_year")
    @Column(name = "birth_year")
    private int birthYear;
    @JsonProperty("death_year")
    @Column(name = "death_year")
    private int deathYear;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> bookList;


    public String getName(){
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public Long getId() { return id; }
}
