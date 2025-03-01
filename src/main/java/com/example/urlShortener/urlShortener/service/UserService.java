package com.example.urlShortener.urlShortener.service;


import com.example.urlShortener.urlShortener.model.User;
import com.example.urlShortener.urlShortener.repository.UserRepository;
import com.example.urlShortener.urlShortener.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(String userName, String password) {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("User with this username already exists");
        }
        User newUser = new User(userName, PasswordUtil.encryptPassword(password));
        userRepository.save(newUser);
        return newUser;
    }

    public User logIn(String userName, String password) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }
        return user;
    }
}
