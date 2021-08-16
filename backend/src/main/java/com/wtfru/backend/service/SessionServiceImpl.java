package com.wtfru.backend.service;

import com.wtfru.backend.dao.SessionDAO;
import com.wtfru.backend.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Transactional
@Service
public class SessionServiceImpl implements SessionService, UserDetailsService {
    @Autowired
    SessionDAO sessionDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Matcher matcher(String password) {
        return Pattern.compile("^(\\d{4})$").matcher(password);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String sessionTitle) throws UsernameNotFoundException {
        SessionDTO session = sessionDAO.getByTitle(sessionTitle);

        if (session == null) {
            throw new UsernameNotFoundException(sessionTitle + " -> 데이터베이스에서 찾을 수 없습니다.");
        }

                return createUser(sessionTitle, new User(session.getTitle(),
                        session.getPassword(),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
    }

    private User createUser(String sessionTitle, User user) {
        if (!user.isAccountNonExpired()) {
            throw new RuntimeException(sessionTitle + " -> 활성화 되어 있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());

        return new User(user.getUsername(), user.getPassword(),grantedAuthorities);
    }

    @Transactional
    @Override
    public SessionDTO postSession(SessionDTO session)
            throws DuplicateTitleException, InvalidPasswordException, SQLProcessException {
        Matcher matcher = matcher(session.getPassword());

        if(sessionDAO.isTitleExisted(session.getTitle())){
            throw new DuplicateTitleException("Duplicate title exists");
        }

        if(!matcher.matches()){
            throw new InvalidPasswordException("Invalid password");
        }

        try {
            // TODO(Sangyeop): change locationLink URL
            sessionDAO.post(session.getTitle(), passwordEncoder.encode(session.getPassword()),
                    "someLink");
        } catch(Exception e) {
            throw new SQLProcessException("Database error occurred");
        }
        SessionDTO result = sessionDAO.getByTitle(session.getTitle());

        return result;
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
