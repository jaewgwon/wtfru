package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dao.SessionDAO;
import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionDAO sessionDAO;

    @Override
    public String postSession(HttpServletRequest request) {
        String password = (String)request.getAttribute("password");

        String pwPattern = "^(?=.*\\d).{4,4}$";
        Matcher matcher = Pattern.compile(pwPattern).matcher(password);

        HashMap<String, SessionDTO> results = new HashMap<String, SessionDTO>();

        if(sessionDAO.isTitleAvailable((String)request.getAttribute("title")) == 0){
            return "duplicate title exists";
        }
        if(!matcher.matches()){
            return "Invalid password";
        }

        try {
            // TODO(Sangyeop): change locationLink URL
            sessionDAO.post((String)request.getAttribute("title"),
                    (String)request.getAttribute("password"),
                    "someLink");
        } catch(Exception e) {
            e.printStackTrace();
            return "Database error";
        }

        return null;
    }

    @Override
    public SessionDTO getSession(HttpServletRequest request) {
        SessionDTO result;
        String sessionTitle = (String)request.getAttribute("title");

        try {
            result = sessionDAO.getByTitle(sessionTitle);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }
}
