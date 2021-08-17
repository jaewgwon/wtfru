package com.wtfru.backend.controller;

import com.wtfru.backend.jwt.JwtFilter;
import com.wtfru.backend.service.TokenService;
import com.wtfru.backend.dto.SessionDTO;
import com.wtfru.backend.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    SessionService sessionService;
    @Autowired
    TokenService tokenService;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    public SessionController(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping(value = "/session", produces = "application/json; charset=utf-8")
    public ResponseEntity<SessionDTO> postSession(@RequestParam String password,
                                      @RequestBody Map<String, String> request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SessionDTO result;
        SessionDTO requestedSession = new SessionDTO();

        requestedSession.setTitle(request.get("title"));
        requestedSession.setPassword(request.get("password"));
        Date expiredDate = new Date();
        try {
            expiredDate = dateFormat.parse(request.get("expired_date"));
        } catch (ParseException e) {
            logger.debug("Given date data is wrong", e);
        }
        requestedSession.setExpiredDate(expiredDate);

        try {
            result = sessionService.postSession(requestedSession);
        } catch (SessionService.DuplicateTitleException de) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (SessionService.InvalidPasswordException ie) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (SessionService.SQLProcessException se) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if(result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + tokenService.createToken(request));

        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
    }
}
