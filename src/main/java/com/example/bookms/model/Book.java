package com.example.bookms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "book")
public class Book {

    @Transient
    public static final String SEQUENCE_NAME = "book_sequence";

    @Id
    private String id;

    private String title;
    private String author;
    private String pub_date;
    private String isbn;
    private String genre;
    private int rating;

}