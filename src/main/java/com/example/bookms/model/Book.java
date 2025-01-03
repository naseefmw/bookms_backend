package com.example.bookms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Getter
@Setter
public class Book {
    @Id
    private String id;

    private String title;
    private String author;
    private Date pub_date;
    private long isbn;
    private String genre;
    private int rating;

}