package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookDto {

    private Long id;
    private String author;
    private String title;
    private int releaseDate;
}
