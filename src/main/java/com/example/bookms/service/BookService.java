package com.example.bookms.service;

import com.example.bookms.model.Book;
import com.example.bookms.repository.BookRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book getBookById(String id) {
        log.info("Getting book {} from the repository.", id);

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            log.info("found {} book by id {}", book.getTitle(), id);
            return book;
        } else {
            log.info("No book found by id {}", id);
            return null;
        }
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book addToBooks(@Valid Book book) {
        log.info("Adding book {} to database", book.getTitle());
        Book book2 = bookRepository.insert(book);
        log.info("Added book {} successfully", book2.getTitle());
        return book2;
    }

    public Book deleteBook(String id) {
        log.info("Finding book {} from the repository.", id);

        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            log.info("deleting {} book by id {}", book.getTitle(), id);
            bookRepository.deleteById(id);
            return book;
        } else {
            log.info("No book found by id {}", id);
            return null;
        }
    }

}