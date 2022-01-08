package com.san.ambitious.spring.springbootdemo.service;

import com.san.ambitious.spring.springbootdemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    List<User> users = new ArrayList<>(Arrays.asList(new User("sanjeev", "sanjeev", "sanjeevkumarpal@gmail.com","Admin"),
            new User("sachin", "sachin", "kyonsp@gmail.com","Normal")));

    public List<User> getUsers() {
        return users;
    }

    public User getUserByName(String userName) {
        return users.stream().filter(user -> user.getUsername().equalsIgnoreCase(userName)).findAny().orElse(null);
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }
}
