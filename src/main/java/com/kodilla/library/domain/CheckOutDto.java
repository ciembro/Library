package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CheckOutDto {

    private Long id;
    private Long bookCopyId;
    private Long userId;
    private LocalDate borrowDate;
    private LocalDate dueDate;
}
