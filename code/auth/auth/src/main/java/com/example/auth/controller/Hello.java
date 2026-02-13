package com.example.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping
    public String getHello() {
        return "Hello World!";
    }

    @PostMapping
    public String postHello() {
        return "Hello! POST request received!";
    }
}
