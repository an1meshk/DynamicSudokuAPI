package com.dynamic.sudoku.exception;

/**
 * Created by Animesh Kumar on 12-05-2018.
 * Application specific exception class to handle exception in the application.
 */
public class DynamicSudokuException extends Exception{
    public DynamicSudokuException() {
        super();
    }

    public DynamicSudokuException(String message) {
        super(message);
    }

    public DynamicSudokuException(String message, Throwable cause) {
        super(message, cause);
    }

    public DynamicSudokuException(Throwable cause) {
        super(cause);
    }

    protected DynamicSudokuException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
