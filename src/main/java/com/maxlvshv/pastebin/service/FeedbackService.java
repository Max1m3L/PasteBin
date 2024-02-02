package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.Feedback;
import com.maxlvshv.pastebin.repository.FeedbackRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepo feedbackRepo;

    public Feedback create(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> showAll() {
        return feedbackRepo.findAll();
    }
}
