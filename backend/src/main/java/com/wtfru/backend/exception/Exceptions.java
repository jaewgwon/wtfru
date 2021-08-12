package com.wtfru.backend.exception;

public class Exceptions extends Exception{

    public static class DuplicateTitleException extends Exception {
        public DuplicateTitleException(String message) {super(message);}
    }
    public static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {super(message);}
    }
    public static class SQLProcessException extends Exception {
        public SQLProcessException(String message) {super(message);}
    }
    public static class SessionNotFoundException extends Exception {
        public SessionNotFoundException(String message) {super(message);}
    }
}
