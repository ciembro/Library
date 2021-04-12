package com.kodilla.library.controller;

import com.kodilla.library.domain.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    @PostMapping(value = "addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserDto userDto){

    }

    @PostMapping(value = "addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto){

    }

    @PostMapping(value = "addBookCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBookCopy(@RequestBody BookCopyDto bookCopyDto){

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
