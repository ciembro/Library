package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Date joinedDate;
    private List<CheckOut> checkOuts;
}
