package com.example.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

        return "Security funcionando";

    }

    @GetMapping("/user")
    public Object user(Authentication auth){

        return auth.getPrincipal();

    }

}