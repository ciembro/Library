package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BookCopyDto {

    private Long id;
    private Long bookId;
    private BookStatus status;
    private Book book;
    private CheckOut checkOut;
}
