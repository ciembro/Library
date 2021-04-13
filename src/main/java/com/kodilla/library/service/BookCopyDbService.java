package com.kodilla.library.service;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import com.kodilla.library.repository.BookCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCopyDbService {

    private final BookCopyRepository bookCopyRepository;

    public BookCopy saveBookCopy(BookCopy bookCopy){
        return bookCopyRepository.save(bookCopy);
    }
}
