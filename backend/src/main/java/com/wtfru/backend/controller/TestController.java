package com.wtfru.backend.controller;

import com.wtfru.backend.session.dao.SessionDAO;
import com.wtfru.backend.session.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//TODO(Sangyeop): Delete unnecessary controller after implement controller layer

@Controller
public class TestController {
    @Autowired
    SessionDAO dao;

    @GetMapping("/test")
    public String testMethod() {
        SessionDTO dto = dao.selectSession(1);
        System.out.println(dto.getLocationLink());
        System.out.println(dto.getUid());

        dao.insertSession("test","1234", "someLink");
        return "testView";
    }

}
