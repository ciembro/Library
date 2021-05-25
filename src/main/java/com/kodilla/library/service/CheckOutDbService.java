package com.kodilla.library.service;

import com.kodilla.library.controller.advice.BookNotAvailableException;
import com.kodilla.library.controller.advice.CheckOutNotFoundException;
import com.kodilla.library.domain.BookCopy;
import com.kodilla.library.domain.BookReturnDto;
import com.kodilla.library.domain.BookStatus;
import com.kodilla.library.domain.CheckOut;
import com.kodilla.library.repository.CheckOutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckOutDbService {

    private final CheckOutRepository checkOutRepository;
    private final BookCopyDbService bookCopyDbService;

    public CheckOut save(CheckOut checkOut){
        return checkOutRepository.save(checkOut);
    }

    public CheckOut createCheckOut(CheckOut checkOut) throws BookNotAvailableException {
        BookCopy bookCopy = checkOut.getBookCopy();
        if (bookCopy.getStatus().equals(BookStatus.AVAILABLE)){
            bookCopy.setStatus(BookStatus.BORROWED);
            bookCopyDbService.save(bookCopy);
            checkOutRepository.save(checkOut);
            return checkOut;
        } else {
            throw new BookNotAvailableException();
        }

    }
    public CheckOut findById(Long checkOutId) throws CheckOutNotFoundException {
        return checkOutRepository.findById(checkOutId)
                .orElseThrow(CheckOutNotFoundException::new);
    }

   public void returnBookCopy(BookReturnDto bookReturnDto) throws CheckOutNotFoundException {
       CheckOut checkOut = findById(bookReturnDto.getCheckOutId());
       if (!checkOut.isClosed()){
           BookCopy bookCopy = checkOut.getBookCopy();
           bookCopy.setStatus(bookReturnDto.getStatus());
           bookCopyDbService.save(bookCopy);
           if (bookCopy.getStatus().equals(BookStatus.AVAILABLE)){
               checkOut.setClosed(true);
           }
           save(checkOut);
       } else {
           throw new CheckOutNotFoundException();
       }


   }
}
