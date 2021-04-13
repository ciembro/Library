package com.kodilla.library.mapper;

import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyDto;
import org.springframework.stereotype.Service;

@Service
public class BookCopyMapper {

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy){
        return new BookCopyDto(bookCopy.getId(),
                bookCopy.getBookId(),
                bookCopy.getStatus(),
                bookCopy.getBook(),
                bookCopy.getCheckOut());
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto){
        return new BookCopy(bookCopyDto.getId(),
                bookCopyDto.getBookId(),
                bookCopyDto.getStatus(),
                bookCopyDto.getBook(),
                bookCopyDto.getCheckOut());
    }
}
