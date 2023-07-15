package org.example.exeptions;

public class ExceptionOfListNumber extends RuntimeException {
    public ExceptionOfListNumber() {
        super();
    }

    public static class IntegerIsNull extends RuntimeException {
        public IntegerIsNull() {
        }

        public IntegerIsNull(String message) {
            super(message);
        }

        public IntegerIsNull(String message, Throwable cause) {
            super(message, cause);
        }

        public IntegerIsNull(Throwable cause) {
            super(cause);
        }

        public IntegerIsNull(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
