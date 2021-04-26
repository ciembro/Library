package com.kodilla.library.domain;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedNativeQuery(
        name = "BookCopy.getCopiesByBookId",
        query = "select id, status from book_copies where book_id = :id",
        resultSetMapping = "listBookCopyDtoMapping"
)

@SqlResultSetMapping(
        name = "listBookCopyDtoMapping",
        classes = @ConstructorResult(
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "status", type = String.class)
                },
                targetClass = ListBookCopyDto.class
        )
)

@NamedNativeQuery(
        name = "BookCopy.getNumberOfCopies",
        query = "select count(*) from book_copies where (book_id = :id && status LIKE 'AVAILABLE')"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book_copies")
public class BookCopy {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @OneToOne(fetch = FetchType.LAZY)
    private CheckOut checkOut;

    public BookCopy(BookStatus status) {
        this.status = status;
    }

    public BookCopy(BookStatus status, Book book, CheckOut checkOut) {
        this.status = status;
        this.book = book;
        this.checkOut = checkOut;
    }

    public BookCopy(Long id, BookStatus status, Book book) {
        this.id = id;
        this.status = status;
        this.book = book;
    }
}
