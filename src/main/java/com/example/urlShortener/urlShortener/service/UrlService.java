package com.example.urlShortener.urlShortener.service;


import com.example.urlShortener.urlShortener.model.Url;
import com.example.urlShortener.urlShortener.repository.UrlRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Url createShortUrl(String originalUrl, ObjectId userId, String shortUrl) {
        if (shortUrl == null) {
            shortUrl = UUID.randomUUID().toString().substring(0, 8);
        }
        Url newUrl = new Url(originalUrl, shortUrl, userId);
        urlRepository.save(newUrl);
        return newUrl;
    }
}
