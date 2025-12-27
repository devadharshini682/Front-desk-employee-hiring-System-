package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.InterviewFeedback;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    private List<Object> feedbacks = new ArrayList<>();

    @Override
    public Object addFeedback(Object obj) {
        feedbacks.add(obj);
        return obj;
    }

    @Override
    public List<Object> getAllFeedbacks() {
        return feedbacks;
    }

    @Override
    public List<InterviewFeedback> getFeedbacksByJobApplication(Long jobApplicationId) {
        throw new UnsupportedOperationException("Unimplemented method 'getFeedbacksByJobApplication'");
    }
}
