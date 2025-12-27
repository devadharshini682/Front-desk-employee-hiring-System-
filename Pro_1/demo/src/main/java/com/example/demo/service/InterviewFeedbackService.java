package com.example.demo.service;

import java.util.List;

import com.example.demo.model.InterviewFeedback;

public interface InterviewFeedbackService {
    Object addFeedback(Object obj);
    List<Object> getAllFeedbacks();
    List<InterviewFeedback> getFeedbacksByJobApplication(Long jobApplicationId);
}
