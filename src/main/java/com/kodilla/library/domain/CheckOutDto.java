package com.kodilla.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class CheckOutDto {

    private Long id;
    private BookCopyDto bookCopyDto;
    private UserDto userDto;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate borrowDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dueDate;

}
