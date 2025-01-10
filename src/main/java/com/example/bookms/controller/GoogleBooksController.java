package com.example.bookms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GoogleBooksController {
    @Value("${gbooksapi.key}")
    String apikey;
    @GetMapping(value = "/gbooks/{isbn}")
    public Object getBookDetails(@PathVariable("isbn") String isbn) {
        String uri = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn + "&key=" + apikey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Object.class);
    }
}
