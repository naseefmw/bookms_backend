package com.example.bookms.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class BookInput {

    @NotNull
    @Size(min = 1,max=100, message = "Title length must be less than 100")
    private String title;

    @NotNull
    @Size(min = 1, max = 50, message = "Author length must be less than 50")
    private String author;

    @NotNull
    private LocalDate pub_date;

    @NotNull
    @Pattern(regexp = "^\\d{13}$", message = "Must be 13 digit number")
    private String isbn;

    private String genre;
    private String image;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

}
