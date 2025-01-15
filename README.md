# BookList

A Book management system backend made with Spring Boot.

## Tech Stack
* Java Spring Boot
* MongoDB
* GraphQL
* Maven

## How to Run
* Clone the repo
* Create an application.properties file
```#!/bin/bash
spring.data.mongodb.uri=<mongodb_connection_string>
gbooksapi.key=<google_books_api-key>
spring.graphql.cors.allowed-origins=http://localhost:3000
spring.graphql.cors.allow-credentials=true
```
* Run BookmsApplication.java
```#!/bin/bash
mvn spring-boot:run
```

## API 
* Find list of Books
```#!/bin/bash
query Booklist {
  findAllBooks{
    id
    title
    author
    rating
  }
}
```
* Book Details
```#!/bin/bash
query Book {
  bookById(id: $id) {
    title
    author
    pub_date
    isbn
    rating
    genre
    image
  }
}
```
* Add Book
```#!/bin/bash
mutation AddBook {
  addBook(
    bookInput: {
      title: $title
      author: $author
      pub_date: $pub_date
      isbn: $isbn
      rating: $rating
      genre: $genre
      image: $image
    }
    ) {
      id
      title
      author
      rating
    }
}
```
* Delete Book
```#!/bin/bash
mutation DeleteBook {
  deleteBook(id: $id) {
    id
  }
}
```
* GET book details from Google books api
```#!/bin/bash
GET http://localhost:8080/gbooks/$isbn
```

## DB Schema
```#!/bin/bash
Book {
  id: ID
  title: String
  author: String
  pub_date: Date
  isbn: String
  rating: Int
  genre: String
  image: String
}
```

## Folder Structure
* config: Contains configuration classes.
* controller: Contains RESTful controller classes and GraphQL queries and mutation mapping.
* model: model folder stores data models.
* repository: Contains repository classes that deal with data access.
* service: Contains service classes that implement business logic.
