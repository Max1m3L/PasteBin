package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.Feedback;
import com.maxlvshv.pastebin.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    final
    FeedbackRepo feedbackRepo;
    @Autowired
    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    public Feedback create(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> showAll() {
        return feedbackRepo.findAll();
    }
}
