package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public interface SessionService {
    // Exceptions
    public static class DuplicateTitleException extends Exception {
        DuplicateTitleException(String message) {
            super(message);
        }
    }
    public static class InvalidPasswordException extends Exception {
        InvalidPasswordException(String message) {
            super(message);
        }
    }
    public static class SQLProcessException extends Exception {
        SQLProcessException(String message) {
            super(message);
        }
    }

    public SessionDTO postSession(@RequestBody Map<String, String> request)
            throws DuplicateTitleException, InvalidPasswordException, SQLProcessException;
    public SessionDTO getSession(String title);
}
