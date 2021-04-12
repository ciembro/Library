package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;

public class BookCopyMapper {

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy){
        return new BookCopyDto(bookCopy.getId(),
                bookCopy.getBookId(),
                bookCopy.getStatus());
    }

    public BookCopy mapToBookCopy(BookCopy bookCopyDto){
        return new BookCopy(bookCopyDto.getId(),
                bookCopyDto.getBookId(),
                bookCopyDto.getStatus());
    }
}
