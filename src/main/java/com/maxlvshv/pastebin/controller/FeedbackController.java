package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.Feedback;
import com.maxlvshv.pastebin.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Feedback feedback) {
        try {
            return ResponseEntity.ok(feedbackService.create(feedback));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't create new feedback" + e);
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
