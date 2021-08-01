package com.wtfru.backend.controller;

import com.wtfru.backend.jwt.JwtFilter;
import com.wtfru.backend.service.TokenService;
import com.wtfru.backend.dto.SessionDTO;
import com.wtfru.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    SessionService sessionService;
    @Autowired
    TokenService tokenService;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public SessionController(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping(value = "/session", produces = "application/json; charset=utf-8")
    public ResponseEntity<SessionDTO> postSession(@RequestParam String password,
                                      @RequestBody Map<String, String> request) {
        SessionDTO result;

        try {
            result = sessionService.postSession(request);
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
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + tokenService.generateJWT(request));

        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
    }
}
