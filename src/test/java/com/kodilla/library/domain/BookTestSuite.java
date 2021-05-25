package com.kodilla.library.domain;

import com.kodilla.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class BookTestSuite {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testSave(){
        //given
        Book book = new Book();
        book.setAuthor("author");
        book.setTitle("title");
        book.setReleaseDate(2000);
        //when
        bookRepository.save(book);
        Long bookId = book.getId();
        //then
        assertNotEquals(0L, book.getId());
        assertEquals(1, bookRepository.findAll().size());
        //cleanup
        bookRepository.deleteById(bookId);
    }

    @Test
    void testUpdate(){
        //given
        Book book = new Book();
        book.setAuthor("author");
        book.setTitle("title");
        book.setReleaseDate(2000);
        bookRepository.save(book);
        Long bookId = book.getId();
        //when
        book.setAuthor("updated author");
        bookRepository.save(book);
        Long updatedBookId = book.getId();
        //then
        assertEquals(bookId, updatedBookId);
        assertEquals("updated author", book.getAuthor());
        //cleanup
        bookRepository.deleteById(bookId);
    }

}
