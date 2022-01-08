package com.san.ambitious.spring.springbootdemo.controller;

import com.san.ambitious.spring.springbootdemo.entity.User;
import com.san.ambitious.spring.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService usrService;

    @GetMapping("/")
    public List<User> getUsers() {
        return usrService.getUsers();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return usrService.addUser(user);
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String username) {
        return usrService.getUserByName(username);
    }

}
