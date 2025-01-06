package com.example.bookms.controller;

import com.example.bookms.model.Book;
import com.example.bookms.model.BookInput;
import com.example.bookms.service.BookService;
import com.example.bookms.service.SequenceGeneratorService;
import graphql.GraphQLError;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@Component
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @QueryMapping
    public Book bookById(@Argument String id) {
        log.info(" Querying book in GraphQL Server by id {}", id);
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @MutationMapping
    public Book addBook(@Argument @Valid BookInput bookInput) {

        Book book = new Book();
        book.setId("B-" + sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME));
        book.setTitle(bookInput.getTitle());
        book.setAuthor(bookInput.getAuthor());
        book.setPub_date(bookInput.getPub_date());
        book.setIsbn(bookInput.getIsbn());
        book.setRating(bookInput.getRating());
        book.setGenre(bookInput.getGenre());
        book.setImage(bookInput.getImage());

        log.info("Book Adding");
        return bookService.addToBooks(book);
    }

    @MutationMapping
    public Book deleteBook(@Argument String id) {
        log.info(" Deleting book in GraphQL Server by id {}", id);
        return bookService.deleteBook(id);
    }

}