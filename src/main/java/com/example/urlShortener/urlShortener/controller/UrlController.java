package com.example.urlShortener.urlShortener.controller;


import com.example.urlShortener.urlShortener.model.Url;
import com.example.urlShortener.urlShortener.service.UrlService;
//import org.bson.types.ObjectId;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<Url> createShortUrl(@RequestBody Map<String, String> payload) {
        ObjectId userId = new ObjectId(payload.get("userId"));
        Url url = urlService.createShortUrl(payload.get("originalUrl"), userId, payload.get("shortUrl"));
        return new ResponseEntity<>(url, HttpStatus.CREATED);
    }

}
