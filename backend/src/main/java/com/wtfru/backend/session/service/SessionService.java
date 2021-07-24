package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Service
public interface SessionService {
    public String postSession(HttpServletRequest request,
                                                     HttpServletResponse response,
                                                     Model model);

    public SessionDTO getSession(HttpServletRequest request);
}
