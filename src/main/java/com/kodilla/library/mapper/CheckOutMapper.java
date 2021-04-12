package com.kodilla.library.mapper;

import com.kodilla.library.domain.CheckOut;
import com.kodilla.library.domain.CheckOutDto;


public class CheckOutMapper {

    public CheckOutDto mapToCheckOutDto(CheckOut checkOut){
        return  new CheckOutDto(checkOut.getId(),
                checkOut.getBookCopyId(),
                checkOut.getUserId(),
                checkOut.getBorrowDate(),
                checkOut.getDueDate());
    }

    public CheckOut mapToCheckOut(CheckOut checkOutDto){
        return  new CheckOut(checkOutDto.getId(),
                checkOutDto.getBookCopyId(),
                checkOutDto.getUserId(),
                checkOutDto.getBorrowDate(),
                checkOutDto.getDueDate());
    }
}
