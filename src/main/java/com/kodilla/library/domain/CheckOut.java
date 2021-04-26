package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "check_outs")
public class CheckOut {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = BookCopy.class)
    @JoinColumn(name = "book_copy_id", insertable = false, updatable = false)
    private BookCopy bookCopy;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "borrow_date")
    @CreationTimestamp
    private LocalDate borrowDate;

    @Column(name = "due_date")
    private LocalDate dueDate = LocalDate.now().plusMonths(1);

}
