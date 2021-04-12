package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;

public class BookMapper {

    public BookDto mapToBookDto(Book book){
        return new BookDto(book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getReleaseDate());
    }

    public Book mapToBook(Book bookDto){
        return new Book(bookDto.getId(),
                bookDto.getAuthor(),
                bookDto.getTitle(),
                bookDto.getReleaseDate());
    }
}
