package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookCopyCreationDto {

    private BookStatus status;
    private Long bookId;
}
