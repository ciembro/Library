package com.kodilla.library.mapper;

import com.kodilla.library.controller.advice.BookNotFoundException;
import com.kodilla.library.domain.CheckOut;
import com.kodilla.library.domain.CheckOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CheckOutMapper {

    private final UserMapper userMapper;
    private final BookCopyMapper bookCopyMapper;

    public CheckOutDto mapToCheckOutDto(CheckOut checkOut){
        return  new CheckOutDto(checkOut.getId(),
                bookCopyMapper.mapToBookCopyDto(checkOut.getBookCopy()),
                userMapper.mapToUserDto(checkOut.getUser()),
                checkOut.getBorrowDate(),
                checkOut.getDueDate());
    }

    public CheckOut mapToCheckOut(CheckOutDto checkOutDto) throws BookNotFoundException {
        return  new CheckOut(checkOutDto.getId(),
                bookCopyMapper.mapToBookCopy(checkOutDto.getBookCopyDto()),
                userMapper.mapToUser(checkOutDto.getUserDto()),
                checkOutDto.getBorrowDate(),
                checkOutDto.getDueDate());
    }
}
