package com.wtfru.backend.service;

import com.wtfru.backend.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
public class TokenService {
    @Autowired
    TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public TokenService(AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public UsernamePasswordAuthenticationToken generateToken(@RequestParam Map<String, String> request) {
        return new UsernamePasswordAuthenticationToken(request.get("title"), request.get("password"));
    }

    public String generateJWT(@RequestParam Map<String, String> request) {
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(generateToken(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.createToken(authentication);
    }
}
