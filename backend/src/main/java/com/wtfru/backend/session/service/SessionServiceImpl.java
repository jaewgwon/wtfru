package com.wtfru.backend.session.service;

import com.wtfru.backend.session.dao.SessionDAO;
import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    SessionDAO sessionDAO;

    @Transactional
    @Override
    public SessionDTO postSession(@RequestBody Map<String, String> request)
            throws DuplicateTitleException, InvalidPasswordException, SQLProcessException {
        String password = request.get("password");

        // TODO(Feedback): inject dependency of Matcher class

        String pwPattern = "^(\\d{4})$";
        Matcher matcher = Pattern.compile(pwPattern).matcher(password);

        if(sessionDAO.isTitleExisted(request.get("title"))){
            throw new DuplicateTitleException("Duplicate title exists");
        }

        if(!matcher.matches()){
            throw new InvalidPasswordException("Invalid password");
        }

        try {
            // TODO(Sangyeop): change locationLink URL
            sessionDAO.post(request.get("title"), request.get("password"),
                    "someLink");
        } catch(Exception e) {
            throw new SQLProcessException("Database error occurred");
        }

        SessionDTO session = sessionDAO.getByTitle(request.get("title"));

        return session;
    }

    @Override
    public SessionDTO getSession(String title) {
        SessionDTO result = null;

        try {
            result = sessionDAO.getByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
