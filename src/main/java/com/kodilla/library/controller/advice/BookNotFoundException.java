package com.kodilla.library.controller.advice;

public class BookNotFoundException extends Exception {

    public static final String BOOK_ID_NOT_FOUND = "Book with provided ID doesn't exist in database.";

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException() {
        super(BOOK_ID_NOT_FOUND);
    }
}
