package com.kodilla.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class CheckOutDto {

    private Long id;
    private Long bookCopyId;
    private Long userId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate borrowDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dueDate;
}
