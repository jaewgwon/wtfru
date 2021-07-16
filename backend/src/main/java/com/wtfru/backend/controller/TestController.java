package com.wtfru.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String testMethod() {
        System.out.println("222");
        return "testView";
    }

}
