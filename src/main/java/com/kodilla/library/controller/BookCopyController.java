package com.kodilla.library.controller;

import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookCopyCreationDto;
import com.kodilla.library.domain.BookCopyDto;
import com.kodilla.library.mapper.BookCopyMapper;
import com.kodilla.library.service.BookCopyDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/bookcopy")
@RequiredArgsConstructor
public class BookCopyController {

    private final BookCopyMapper bookCopyMapper;
    private final BookCopyDbService bookCopyDbService;

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

    @GetMapping(value = "getBookCopies")
    public List<BookCopyDto> getBookCopies(@RequestParam Long bookId){
        return bookCopyDbService.findBookCopiesByBookId(bookId);
    }
}
