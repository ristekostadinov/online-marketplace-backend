package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.requests.UserRequest;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public User saveUser(@RequestBody UserRequest userRequest){
        return this.userService.saveUser(userRequest);
    }
}
