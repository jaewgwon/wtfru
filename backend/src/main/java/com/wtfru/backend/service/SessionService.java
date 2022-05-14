package com.wtfru.backend.service;

import com.wtfru.backend.dto.SessionDTO;
import com.wtfru.backend.exception.DataIOException.*;
import com.wtfru.backend.exception.ValidationException.*;
import org.springframework.stereotype.Service;

@Service
public interface SessionService {
    public SessionDTO postSession(SessionDTO session)
            throws InvalidPasswordException, SQLProcessException, DuplicateTitleException;
    public SessionDTO getSession(String title);
}
