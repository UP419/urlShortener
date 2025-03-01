package com.example.urlShortener.urlShortener.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encryptPassword(String plainPassword){
        return encoder.encode(plainPassword);
    }

    public static boolean verifyPassword(String plainPassword, String encodedPassword){
        return encoder.matches(plainPassword, encodedPassword);
    }
}
