package org.example.exeptions;

public class IntegerListIsFull extends RuntimeException {
    public IntegerListIsFull() {
    }

    public IntegerListIsFull(String message) {
        super(message);
    }

    public IntegerListIsFull(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegerListIsFull(Throwable cause) {
        super(cause);
    }

    public IntegerListIsFull(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
