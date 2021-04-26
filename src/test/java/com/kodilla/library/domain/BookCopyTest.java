package com.kodilla.library.domain;

import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookCopyTest {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookCopyRepository bookCopyRepository;
    @Test
    void testGetByBookId(){
        //given
        Book book = new Book("testAuth", "testTitle", 2020);
        BookCopy bookCopy = new BookCopy(BookStatus.AVAILABLE);
        book.getBookCopies().add(bookCopy);
        bookCopy.setBook(book);
        bookRepository.save(book);
        Long bookId = book.getId();
        Long bookCopyId = bookCopy.getId();
        //when
        List<ListBookCopyDto> bookCopies = bookCopyRepository.getCopiesByBookId(bookId);
        //then
        try {
            assertEquals(1, bookCopies.size());
        } finally {
            bookRepository.deleteById(bookId);
        }
    }

    @Test
    void testGetNumOfCopies(){
        //given
        Book book = new Book("testAuth", "testTitle", 2020);
        BookCopy bookCopy = new BookCopy(BookStatus.AVAILABLE);
        book.getBookCopies().add(bookCopy);
        bookCopy.setBook(book);
        bookRepository.save(book);
        Long bookId = book.getId();
        Long bookCopyId = bookCopy.getId();
        //when
        int copies = bookCopyRepository.getNumberOfCopies(bookId);
        //then
        try {
            assertEquals(1, copies);
        } finally {
            bookRepository.deleteById(bookId);
        }
    }

}