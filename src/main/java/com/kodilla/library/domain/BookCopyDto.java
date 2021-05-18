package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookCopyDto {

    private Long id;
    private BookStatus status;
    private Long bookId;

    public BookCopyDto(Long id, String status, Long bookId) {
        this.id = id;
        this.status = BookStatus.valueOf(status);
        this.bookId = bookId;
    }
}
