package com.kodilla.library.domain;

import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.BookRepository;
import com.kodilla.library.service.BookCopyDbService;
import com.kodilla.library.service.BookDbService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookCopyTestSuite {

    @Autowired
    BookCopyDbService bookCopyDbService;

    @Autowired
    BookDbService bookDbService;

    @Test
    void testSave(){
        //given
        Book book = new Book();
        book.setAuthor("author");
        book.setTitle("title");
        book.setReleaseDate(2000);
        bookDbService.save(book);
        BookCopy bookCopy = new BookCopy();
        bookCopy.setBook(book);
        bookCopy.setStatus(BookStatus.AVAILABLE);

        //when
        bookCopyDbService.save(bookCopy);
        Long bookCopyId = bookCopy.getId();
        //then
        Long bookId = book.getId();
        assertNotEquals(0L, bookCopyId);
        assertEquals(bookId, bookCopy.getBook().getId());
        //cleanup
        bookCopyDbService.deleteById(bookCopyId);
        bookDbService.deleteById(bookId);
    }

    @Test
    void findBookCopiesByBookId(){
        Book book = new Book();
        book.setAuthor("author");
        book.setTitle("title");
        book.setReleaseDate(2000);
        bookDbService.save(book);
        Long bookId = book.getId();
        BookCopy bookCopy = new BookCopy();
        bookCopy.setBook(book);
        bookCopy.setStatus(BookStatus.AVAILABLE);
        bookCopyDbService.save(bookCopy);
        Long bcId1 = bookCopy.getId();
        bookCopy = new BookCopy();
        bookCopy.setBook(book);
        bookCopy.setStatus(BookStatus.BORROWED);
        bookCopyDbService.save(bookCopy);
        Long bcId2 = bookCopy.getId();
        //when
        try {
            List<BookCopyDto> bookCopies = bookCopyDbService.findBookCopiesByBookId(book.getId());
            assertEquals(2, bookCopies.size());
        } catch (BookNotFoundException e){
            //do nothing
        } finally {
            bookCopyDbService.deleteById(bcId1);
            bookCopyDbService.deleteById(bcId2);
            bookDbService.deleteById(bookId);
        }
    }


}