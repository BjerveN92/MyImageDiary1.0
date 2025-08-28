package com.example.MyImageDiary10.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.MyImageDiary10.models.Entry;

public interface EntryRepository extends MongoRepository<Entry, String> {
    // get all entries from specific user and sort them by date (newest first)
    List<Entry> findByUserIdOrderByCreatedAtDesc(String userId);
}
