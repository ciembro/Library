package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "book_copies")
public class BookCopy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @NotNull
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checkOut_id")
    private CheckOut checkOut;
}
