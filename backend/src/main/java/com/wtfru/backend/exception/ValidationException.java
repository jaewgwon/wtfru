package com.wtfru.backend.exception;

public class ValidationException extends Exception {
    public static class DuplicateTitleException extends Exception {
        public DuplicateTitleException(String message) {super(message);}
    }
    public static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {super(message);}
    }
}
