package com.kodilla.library.mapper;

import com.kodilla.library.domain.*;
import com.kodilla.library.service.BookDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookCopyMapper {

    private final BookMapper bookMapper;

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy){

        return new BookCopyDto(bookCopy.getId(),
                bookCopy.getStatus(),
                bookMapper.mapToBookDto(bookCopy.getBook()));
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto) {
        return new BookCopy(bookCopyDto.getId(),
                bookCopyDto.getStatus(),
                bookMapper.mapToBook(bookCopyDto.getBookDto()));
    }

    public ListBookCopyDto mapToListBookCopyDto(BookCopy bookCopy){
        return new ListBookCopyDto(bookCopy.getId(),
                bookCopy.getStatus());
    }

    public List<ListBookCopyDto> mapToListBookCopies(List<BookCopy> bookCopies){
        return bookCopies.stream()
                .map(this::mapToListBookCopyDto)
                .collect(Collectors.toList());
    }

}
