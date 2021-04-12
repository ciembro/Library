package com.kodilla.library.service;

import com.kodilla.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDbService {

    private final BookRepository bookRepository;
}
