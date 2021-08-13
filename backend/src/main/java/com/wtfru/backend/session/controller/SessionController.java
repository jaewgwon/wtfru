package com.wtfru.backend.session.controller;

import com.wtfru.backend.session.dto.SessionDTO;
import com.wtfru.backend.session.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @PostMapping(value = "/session", produces = "application/json; charset=utf-8")
    public ResponseEntity postSession(@RequestParam String password,
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

        return ResponseEntity.ok(result);
    }
}
