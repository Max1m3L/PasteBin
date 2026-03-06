package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback create(Feedback feedback);

    List<Feedback> showAll();
}
