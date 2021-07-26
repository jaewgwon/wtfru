package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dao.SessionDAO;
import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionDAO sessionDAO;

    @Override
    public String postSession(Map<String, String> request) {
        String password = request.get("password");

        String pwPattern = "^(?=.*\\d).{4,4}$";
        Matcher matcher = Pattern.compile(pwPattern).matcher(password);

        if(sessionDAO.isTitleAvailable(request.get("title")) == 0){
            return "duplicate title exists";
        }
        if(!matcher.matches()){
            return "Invalid password";
        }

        try {
            // TODO(Sangyeop): change locationLink URL
            sessionDAO.post(request.get("title"), request.get("password"),
                    "someLink");
        } catch(Exception e) {
            e.printStackTrace();
            return "Database error";
        }

        return null;
    }

    @Override
    public SessionDTO getSession(String title) {
        SessionDTO result;

        try {
            result = sessionDAO.getByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }
}
