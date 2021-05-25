package com.kodilla.library.controller.advice;

public class BookCopyNotFoundException extends Exception{

    public static final String BOOK_COPY_ID_NOT_FOUND = "Book copy with provided ID " +
            "doesn't exist in database.";

    public BookCopyNotFoundException() {
        super(BOOK_COPY_ID_NOT_FOUND);
    }
}
