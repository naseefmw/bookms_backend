package com.example.bookms.controller;

import com.example.bookms.model.Book;
import com.example.bookms.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        log.info(" Querying book in GraphQL Server by id {}", id);
        Book book = bookService.getBookById(id);
        return book;
    }

    @MutationMapping
    public Book addBook(@Argument String title, @Argument String author, @Argument String pub_date, @Argument String isbn, @Argument int rating) {

        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setTitle(title);
        book.setAuthor(author);
        book.setPub_date(pub_date);
        book.setIsbn(isbn);
        book.setRating(rating);

        bookService.addBook(book);

        return book;
    }


}