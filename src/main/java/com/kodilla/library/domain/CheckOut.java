package com.kodilla.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

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

    @Column(name = "bookCopy_id")
    @NotNull
    private Long bookCopyId;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "borrow_date")
    @NotNull
    private Date borrowDate;

    @Column(name = "due_date")
    @NotNull
    private Date dueDate;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private User user;

    @OneToOne(mappedBy = "checkOut",
        fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private BookCopy bookCopy;
}
