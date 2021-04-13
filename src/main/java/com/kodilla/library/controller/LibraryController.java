package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.BookCopyMapper;
import com.kodilla.library.mapper.BookMapper;
import com.kodilla.library.mapper.CheckOutMapper;
import com.kodilla.library.mapper.UserMapper;
import com.kodilla.library.service.BookCopyDbService;
import com.kodilla.library.service.BookDbService;
import com.kodilla.library.service.CheckOutDbService;
import com.kodilla.library.service.UserDbService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/library")
@AllArgsConstructor
public class LibraryController {

    private final BookDbService bookDbService;
    private final BookMapper bookMapper;
    private final BookCopyDbService bookCopyDbService;
    private final BookCopyMapper bookCopyMapper;
    private final CheckOutDbService checkOutDbService;
    private final CheckOutMapper checkOutMapper;
    private final UserDbService userDbService;
    private final UserMapper userMapper;

    @PostMapping(value = "addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserDto userDto){
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
    }

    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto){
        Book book = bookMapper.mapToBook(bookDto);
        bookDbService.saveBook(book);
    }

    @GetMapping(value = "getAllBooks")
        public List<BookDto> getAllBooks(){
            List<Book> books = bookDbService.getAllBooks();
            return bookMapper.mapToBookDtoList(books);
        }


    @PostMapping(value = "addBookCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBookCopy(@RequestBody BookCopyDto bookCopyDto){
        BookCopy bookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
        bookCopyDbService.saveBookCopy(bookCopy);
    }

    @PutMapping("changeStatus")
    public void changeBookStatus(@RequestParam BookStatus bookStatus){

    }

    @GetMapping("getAvailableCopies")
    public int getNumOfAvailableCopies(@RequestParam Long bookId){

        return 0;
    }

    @PostMapping(value = "checkOut", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void checkOut(@RequestBody CheckOutDto checkOutDto){

    }

    @PutMapping(value = "returnBook")
    public void returnBook(@RequestParam Long checkOutId){

    }


}
