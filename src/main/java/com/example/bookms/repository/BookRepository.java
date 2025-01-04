package com.example.bookms.repository;

import java.util.List;
import com.example.bookms.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}