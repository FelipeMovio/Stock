package com.felipemovio.stock.exception;


public class PageSizeExceededException extends RuntimeException {

    public PageSizeExceededException(String message) {
        super(message);
    }
}
