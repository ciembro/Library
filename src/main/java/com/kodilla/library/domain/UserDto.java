package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate joinedDate;
}
