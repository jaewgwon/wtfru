package com.wtfru.backend.exception;

public class DataIOException extends Exception{
    public static class SQLProcessException extends Exception {
        public SQLProcessException(String message) {super(message);}
    }
    public static class SessionNotFoundException extends Exception {
        public SessionNotFoundException(String message) {super(message);}
    }
}
