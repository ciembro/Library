package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "checkOuts")
public class CheckOut {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "bookCopyId")
    @NotNull
    private Long bookCopyId;

    @Column(name = "userId")
    @NotNull
    private Long userId;

    @Column(name = "borrowDate")
    @NotNull
    private LocalDate borrowDate;

    @Column(name = "dueDate")
    @NotNull
    private LocalDate dueDate;
}
