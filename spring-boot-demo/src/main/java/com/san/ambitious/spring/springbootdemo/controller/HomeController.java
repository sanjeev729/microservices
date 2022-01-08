package com.san.ambitious.spring.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    public String getHome() {
        return "This is home page";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "This is registration page";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "This is login page";
    }
}
