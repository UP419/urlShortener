package com.example.urlShortener.urlShortener.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    private String id;
    private String originalUrl;
    private String shortUrl;
    private ObjectId userId;

    public Url(String originalUrl, String shortUrl, ObjectId userId) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
        this.userId = userId;
    }

}
