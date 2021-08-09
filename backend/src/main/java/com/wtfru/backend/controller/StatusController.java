package com.wtfru.backend.controller;

import com.wtfru.backend.exception.Exceptions;
import com.wtfru.backend.service.StatusService;
import com.wtfru.backend.session.dto.SessionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/session")
public class StatusController {
    @Autowired
    StatusService statusService;
    @Autowired
    TokenService tokenService;

    private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

    @GetMapping(value = "/status", produces = "application/json; charset=utf-8")
    public ResponseEntity getStatus(@RequestBody Map<String, String> request) {
        SessionDTO result = null;
        try {
            result = statusService.getStatus(request);
        } catch (Exception e) {
            logger.debug("Database error occured", e);
            return ResponseEntity.status(404).body("message: The session is not found");
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/status", produces = "application/json; charset=utf-8")
    public ResponseEntity<String> putStatus(@RequestBody Map<String, String> request) {
        try {
            statusService.putStatus(request);
        } catch (Exceptions.SessionNotFoundException e) {
            logger.debug("Database error occurred", e);
            return ResponseEntity.status(404).body("message: The session does not exist");
        }
        return ResponseEntity.ok("message: Status has been updated");
    }
}
