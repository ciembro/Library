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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "release_date")
    private int releaseDate;

    @OneToMany(
            targetEntity = BookCopy.class,
            mappedBy = "book",
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
