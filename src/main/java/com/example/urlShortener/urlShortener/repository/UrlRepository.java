package com.example.urlShortener.urlShortener.repository;

import com.example.urlShortener.urlShortener.model.Url;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, ObjectId> {
}
