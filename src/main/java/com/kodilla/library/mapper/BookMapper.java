package com.kodilla.library.mapper;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookMapper {

    public BookDto mapToBookDto(final Book book){
        return new BookDto(book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getReleaseDate(),
                book.getBookCopies());
    }

    public Book mapToBook(final BookDto bookDto){
        return new Book(bookDto.getId(),
                bookDto.getAuthor(),
                bookDto.getTitle(),
                bookDto.getReleaseDate(),
                bookDto.getBookCopies());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> books){
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
