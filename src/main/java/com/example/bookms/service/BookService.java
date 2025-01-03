package com.example.bookms.service;

import com.example.bookms.model.Book;
import com.example.bookms.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

        if (optionalBook == null || optionalBook.get() == null) {
            log.info("No book found by id {}", id);
            return null;
        }

        Book book = optionalBook.get();
        log.info("found {} books by id {}", book.getTitle(), id);
        return book;
    }

    public List<Book> getBookByTitle(String title) {
        log.info("Getting Book {} from the repository.", title);

        List<Book> bookList = bookRepository.findByTitle(title);

        if (CollectionUtils.isEmpty(bookList)) {
            log.info("No book found by title {}", title);
            return new ArrayList<Book>();
        }
        log.info("found {} books by title {}", bookList.size(), title);
        return bookList;
    }

    public Book addBook(Book book) {
        log.info("Adding book {} to database", book.getTitle());
        Book book2 = bookRepository.insert(book);
        log.info("Added book {} successfully", book2.getTitle());
        return book2;
    }
}