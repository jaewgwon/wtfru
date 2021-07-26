package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SessionService {
    public String postSession(Map<String, String> request);

    public SessionDTO getSession(String title);
}
