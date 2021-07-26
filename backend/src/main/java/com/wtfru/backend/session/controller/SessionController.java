package com.wtfru.backend.session.controller;

import com.wtfru.backend.session.dao.SessionDAO;
import com.wtfru.backend.session.dto.SessionDTO;
import com.wtfru.backend.session.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    SessionService sessionService;
    @Autowired
    SessionDAO sessionDAO;

    @PostMapping(value = "/session", produces = "application/json; charset=utf-8")
    public ResponseEntity postSession(@RequestParam String password, HttpServletRequest request,
                                      @RequestBody Map<String, String> rMap) {
        System.out.println(rMap.get("title"));

        System.out.println(request.getAttribute("title"));
        System.out.println(request.getAttribute("password"));
        System.out.println(request.getAttribute("expired_date"));
        SessionDTO session = new SessionDTO();
        String result = sessionService.postSession(request);

        if(result != null) {
            return ResponseEntity.badRequest().build();
        }

        session = sessionService.getSession(request);

        if(session != null) {
            return ResponseEntity.status(500).build();
        }

        System.out.println(session);

        return ResponseEntity.ok(session);
    }
}
