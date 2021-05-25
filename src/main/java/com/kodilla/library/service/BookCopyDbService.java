package com.kodilla.library.service;

import com.kodilla.library.controller.advice.BookCopyNotFoundException;
import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodilla.library.controller.advice.BookNotFoundException.BOOK_ID_NOT_FOUND;


@Service
@RequiredArgsConstructor
public class BookCopyDbService {

    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;


    public BookCopy save(BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }

    public BookCopy findById(Long bookCopyId) throws BookCopyNotFoundException {
        return bookCopyRepository.findById(bookCopyId).orElseThrow(BookCopyNotFoundException::new);
    }

    public void deleteById(Long bookCopyId){
        bookCopyRepository.deleteById(bookCopyId);
    }

    public List<BookCopyDto> findBookCopiesByBookId(final Long bookId) throws BookNotFoundException {
        if (bookRepository.findById(bookId).isPresent()){
            return bookCopyRepository.getCopiesByBookId(bookId);
        } else {
            throw new BookNotFoundException(BOOK_ID_NOT_FOUND);
        }
    }

    public int getNumberOfAvailableCopies(final Long bookId) throws BookNotFoundException {
        if (bookRepository.findById(bookId).isPresent()){
            return bookCopyRepository.getNumberOfAvailableCopies(bookId);
        } else {
            throw new BookNotFoundException(BOOK_ID_NOT_FOUND);
        }
    }

}
