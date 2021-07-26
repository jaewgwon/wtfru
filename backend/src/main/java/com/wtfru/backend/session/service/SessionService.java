package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface SessionService {
    public String postSession(HttpServletRequest request);
    public SessionDTO getSession(HttpServletRequest request);
}
