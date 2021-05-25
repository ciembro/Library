package com.kodilla.library.controller;

import com.kodilla.library.domain.Book;
import com.kodilla.library.domain.BookDto;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/book/")
@RequiredArgsConstructor
public class BookController {

    private final BookMapper bookMapper;
    private final BookDbService bookDbService;

    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto addBook(@RequestBody BookDto bookDto){
        Book book = bookMapper.mapToBook(bookDto);
        return bookMapper.mapToBookDto(bookDbService.save(book));
    }

    @GetMapping(value = "getAllBooks")
    public List<BookDto> getAllBooks(){
        List<Book> books = bookDbService.getAllBooks();
        return bookMapper.mapToBookDtoList(books);
    }


}
