package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class ListBookCopyDto {

    private Long id;
    private BookStatus status;

    public ListBookCopyDto(Long id, String status) {
        this.id = id;
        this.status = BookStatus.valueOf(status);
    }
}
