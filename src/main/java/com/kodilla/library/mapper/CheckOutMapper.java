package com.kodilla.library.mapper;

import com.kodilla.library.controller.advice.BookCopyNotFoundException;
import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.controller.advice.UserNotFoundException;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.CheckOut;
import com.kodilla.library.domain.CheckOutDto;
import com.kodilla.library.domain.User;
import com.kodilla.library.service.BookCopyDbService;
import com.kodilla.library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckOutMapper {

    private final BookCopyDbService bookCopyDbService;
    private final UserDbService userDbService;

    public CheckOutDto mapToCheckOutDto(CheckOut checkOut){
        return  new CheckOutDto(checkOut.getId(),
                checkOut.getBookCopy().getId(),
                checkOut.getUser().getId(),
                checkOut.getBorrowDate(),
                checkOut.getDueDate());
    }

    public CheckOut mapToCheckOut(CheckOutDto checkOutDto) throws UserNotFoundException, BookCopyNotFoundException {
        User user = userDbService.findById(checkOutDto.getUserId());
        BookCopy bookCopy = bookCopyDbService.findById(checkOutDto.getBookCopyId());

        return new CheckOut(checkOutDto.getId(),
                bookCopy,
                user);
    }
}
