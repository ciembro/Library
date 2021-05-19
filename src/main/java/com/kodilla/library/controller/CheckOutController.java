package com.kodilla.library.controller;

import com.kodilla.library.controller.advice.BookCopyNotFoundException;
import com.kodilla.library.controller.advice.BookNotAvailableException;
import com.kodilla.library.controller.advice.UserNotFoundException;
import com.kodilla.library.domain.CheckOutDto;
import com.kodilla.library.mapper.CheckOutMapper;
import com.kodilla.library.service.CheckOutDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/checkout")
@RequiredArgsConstructor
public class CheckOutController {

    private final CheckOutMapper checkOutMapper;
    private final CheckOutDbService checkOutDbService;

    @PostMapping(value = "checkOut", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void checkOut(@RequestBody CheckOutDto checkOutDto) throws UserNotFoundException,
            BookCopyNotFoundException, BookNotAvailableException {

    }


    @PutMapping(value = "returnBook")
    public void returnBook(@RequestParam Long checkOutId){

    }
}
