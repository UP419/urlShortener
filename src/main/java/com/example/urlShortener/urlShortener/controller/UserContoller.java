package com.example.urlShortener.urlShortener.controller;


import com.example.urlShortener.urlShortener.model.User;
import com.example.urlShortener.urlShortener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserContoller {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<User> singUp(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(userService.signUp(payload.get("username"), payload.get("password")), HttpStatus.CREATED);
    }

    @GetMapping("/log-in")
    public ResponseEntity<User> logIn(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(userService.logIn(payload.get("username"), payload.get("password")), HttpStatus.OK);
    }
}
