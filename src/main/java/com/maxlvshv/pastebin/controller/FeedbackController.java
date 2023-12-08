package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.Feedback;
import com.maxlvshv.pastebin.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Feedback feedback) {
        try {
            return ResponseEntity.ok(feedbackService.create(feedback));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't create new feedback");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        try {
            return ResponseEntity.ok(feedbackService.showAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't show feedback");
        }
    }
}
