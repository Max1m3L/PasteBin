package com.maxlvshv.pastebin.repository;

import com.maxlvshv.pastebin.entity.Feedback;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
@EntityScan
public interface FeedbackRepo extends MongoRepository<Feedback, String> {
    List<Feedback> findAll();
}
