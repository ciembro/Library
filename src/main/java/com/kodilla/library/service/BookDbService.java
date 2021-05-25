package com.kodilla.library.service;

import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.domain.Book;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodilla.library.controller.advice.BookNotFoundException.BOOK_ID_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;

    public Book save(final Book book){
        return bookRepository.save(book);
    }

    public void deleteById(final Long bookId){
        bookRepository.deleteById(bookId);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book findById(final Long bookId) throws BookNotFoundException {
        return bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }


}
