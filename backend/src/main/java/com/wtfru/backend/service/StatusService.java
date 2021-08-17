package com.wtfru.backend.service;

import com.wtfru.backend.exception.Exceptions;
import com.wtfru.backend.dto.SessionDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface StatusService {
    public void putStatus(SessionDTO session) throws Exceptions.SessionNotFoundException;
    public SessionDTO getStatus(SessionDTO session);
}
