package com.kodilla.library.controller.advice;

public class BookNotAvailableException extends Exception {

    public static final String BOOK_COPY_NOT_AVAILABLE = "Requested book copy is unavailable";

    public BookNotAvailableException() {
        super(BOOK_COPY_NOT_AVAILABLE);
    }
}
