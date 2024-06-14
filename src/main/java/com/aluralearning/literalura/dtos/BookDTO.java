package com.aluralearning.literalura.dtos;

import com.aluralearning.literalura.entities.Author;
import java.util.List;

public record BookDTO(
                     String title,
                     Author author,
                     List<String> languages,
                     Long totalDownloads){

    @Override
    public String toString(){
        String languagesString = String.join(", ", languages);
        return "----- Book -----\n" +
                "Title: " + title +
                "\nAuthor: " + author.getName() +
                "\nLanguages: " + languagesString +
                "\nTotal Downloads: " + totalDownloads + "\n" +
                "-------------------";
    }
}
