package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "check_outs")
public class CheckOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @OneToOne(targetEntity = BookCopy.class)
    @JoinColumn(name = "book_copy_id")
    @NotNull
    private BookCopy bookCopy;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "borrow_date")
    @CreationTimestamp
    private LocalDate borrowDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "is_closed")
    private boolean isClosed;

    public CheckOut(Long id, BookCopy bookCopy, User user) {
        this.id = id;
        this.bookCopy = bookCopy;
        this.user = user;
        this.isClosed = false;
        this.borrowDate = LocalDate.now();
        this.dueDate = LocalDate.now().plusMonths(1L);
    }
}
