package com.aluralearning.literalura.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("title")
    @Column(unique = true)
    private String title;
    @JsonProperty("totalDownloads")
    @Column(name = "total_downloads")
    private Long downloads;
    @JsonProperty("author")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;
    @JsonProperty("languages")
    private List<String> languages;


    public Book(){

    }

    public Book(String title, Author author, List<String> languages, Long downloads) {
        this.title = title;
        this.downloads = downloads;
        this.author = author;
        this.languages = languages;
    }
}
