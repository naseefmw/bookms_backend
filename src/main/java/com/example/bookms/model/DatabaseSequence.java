package com.example.bookms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "db_sequence")
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;
}
