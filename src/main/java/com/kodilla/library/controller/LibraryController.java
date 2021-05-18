package com.kodilla.library.controller;

import com.kodilla.library.controller.advice.BookCopyNotFoundException;
import com.kodilla.library.controller.advice.BookNotAvailableException;
import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.controller.advice.UserNotFoundException;
import com.kodilla.library.domain.*;
import com.kodilla.library.mapper.*;
import com.kodilla.library.service.BookCopyDbService;
import com.kodilla.library.service.BookDbService;
import com.kodilla.library.service.CheckOutDbService;
import com.kodilla.library.service.UserDbService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public BookDto addBook(@RequestBody BookDto bookDto){
        Book book = bookMapper.mapToBook(bookDto);
        return bookMapper.mapToBookDto(bookDbService.saveBook(book));
    }

    @GetMapping(value = "getAllBooks")
        public List<BookDto> getAllBooks(){
            List<Book> books = bookDbService.getAllBooks();
            return bookMapper.mapToBookDtoList(books);
        }

    @GetMapping(value = "getBookCopies")
    public List<BookCopyDto> getBookCopies(@RequestParam Long bookId){
        return bookCopyDbService.findBookCopiesByBookId(bookId);
    }

    @PostMapping(value = "addBookCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookCopyDto addBookCopy(@RequestBody BookCopyCreationDto bookCopyDto) throws BookNotFoundException {
        BookCopy bookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
        bookCopyDbService.saveBookCopy(bookCopy);
        return bookCopyMapper.mapToBookCopyDto(bookCopy);
    }

    @PutMapping("changeStatus")
    public BookCopyDto changeBookStatus(@RequestBody BookCopyDto bookCopyDto) throws BookNotFoundException {
        BookCopy updatedBookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
        bookCopyDbService.saveBookCopy(updatedBookCopy);
        return bookCopyMapper.mapToBookCopyDto(updatedBookCopy);

    }

    @GetMapping("getAvailableCopies")
    public int getNumOfAvailableCopies(@RequestParam Long bookId) throws BookNotFoundException{
        return bookCopyDbService.getNumberOfCopies(bookId);
    }

    @PostMapping(value = "checkOut", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void checkOut(@RequestBody CheckOutDto checkOutDto) throws UserNotFoundException,
            BookCopyNotFoundException, BookNotAvailableException {

    }



    @PutMapping(value = "returnBook")
    public void returnBook(@RequestParam Long checkOutId){

    }
}
