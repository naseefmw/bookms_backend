package com.example.bookms.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class BookInput {

    @NotNull
    @Size(min=1, max=6)
    private String title;

    @NotNull
    @Size(max = 50, message = "Author is too long!")
    private String author;

    private LocalDate pub_date;

    @Size(max=13)
    private String isbn;

    private String genre;
    private String image;

    @Max(5)
    @Min(1)
    private int rating;

}
