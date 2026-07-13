package com.example.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }
    @GetMapping("/about")
    public String about() {
        return "This is my first Spring Boot application";
    }

    
}

