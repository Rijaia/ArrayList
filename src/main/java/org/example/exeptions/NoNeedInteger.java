package org.example.exeptions;

public class NoNeedInteger extends RuntimeException {
    public NoNeedInteger() {
    }

    public NoNeedInteger(String message) {
        super(message);
    }

    public NoNeedInteger(String message, Throwable cause) {
        super(message, cause);
    }

    public NoNeedInteger(Throwable cause) {
        super(cause);
    }

    public NoNeedInteger(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
