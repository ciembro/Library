package com.kodilla.library.mapper;

import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.domain.*;
import com.kodilla.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookCopyMapper {

    private final BookDbService bookDbService;

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy){
        return new BookCopyDto(bookCopy.getId(),
                bookCopy.getStatus(),
                bookCopy.getBook().getId());
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto) throws BookNotFoundException {
        Book book = bookDbService.findById(bookCopyDto.getBookId());

        return new BookCopy(bookCopyDto.getId(),
                bookCopyDto.getStatus(),
                book);


    }

    public BookCopy mapToBookCopy(BookCopyCreationDto bookCopyDto) throws BookNotFoundException {
        Book book = bookDbService.findById(bookCopyDto.getBookId());

        return new BookCopy(bookCopyDto.getStatus(),
                book);
    }

    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookCopies){
        return bookCopies.stream()
                .map(this::mapToBookCopyDto)
                .collect(Collectors.toList());
    }

}
