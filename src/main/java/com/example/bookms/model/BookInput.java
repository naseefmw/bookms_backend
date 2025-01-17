package com.example.bookms.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class BookInput {

    @NotNull
    @Size(max=100, message = "Title length must be less than or equal to 100")
    @Size(min = 1, message = "Title is required")
    private String title;

    @NotNull
    @Size(max = 50, message = "Author length must be less than or equal to 50")
    @Size(min = 1, message = "Author is required")
    private String author;

    @NotNull
    private LocalDate pub_date;

    @NotNull
    @Pattern(regexp = "^\\d{13}$", message = "Must be a 13 digit number")
    private String isbn;

    private String genre;
    private String image;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

}
