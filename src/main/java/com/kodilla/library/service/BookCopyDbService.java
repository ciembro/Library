package com.kodilla.library.service;

import com.kodilla.library.controller.advice.BookCopyNotFoundException;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import com.kodilla.library.repository.BookCopyRepository;
import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookCopyDbService {

    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;


    public BookCopy saveBookCopy(BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }

    public Optional<BookCopy> findBookCopyById(Long bookCopyId) throws BookCopyNotFoundException {
        return bookCopyRepository.findById(bookCopyId);
    }

    public List<BookCopyDto> findBookCopiesByBookId(final Long bookId){
        return bookCopyRepository.getCopiesByBookId(bookId);
    }

    public int getNumberOfCopies(final Long bookId){
        return bookCopyRepository.getNumberOfCopies(bookId);
    }



}
