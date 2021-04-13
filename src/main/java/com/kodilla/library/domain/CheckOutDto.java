package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Getter
public class CheckOutDto {

    private Long id;
    private Long bookCopyId;
    private Long userId;
    private Date borrowDate;
    private Date dueDate;
    private User user;
    private BookCopy bookCopy;
}
