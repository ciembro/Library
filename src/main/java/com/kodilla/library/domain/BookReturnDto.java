package com.kodilla.library.domain;

import lombok.Data;

@Data
public class BookReturnDto {

    private Long checkOutId;
    private BookStatus status;
}
