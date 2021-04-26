package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private int releaseDate;

    @OneToMany(
            targetEntity = BookCopy.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BookCopy> bookCopies = new ArrayList<>();

    public Book(String author, String title, int releaseDate) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Book(Long id, String author, String title, int releaseDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }


}
