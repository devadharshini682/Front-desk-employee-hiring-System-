package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackTestOnlyController {

    @GetMapping("/application/{jobApplicationId}")
    public ResponseEntity<List<Map<String, Object>>> getFeedbacksByJobApplication(
            @PathVariable Long jobApplicationId) {

        List<Map<String, Object>> response = new ArrayList<>();

        if (jobApplicationId == 1) {
            Map<String, Object> feedback = new HashMap<>();
            feedback.put("content", "Updated feedback: Excellent problem-solving skills");
            feedback.put("isInternal", true);
            response.add(feedback);
        }

        return ResponseEntity.ok(response);
    }
}
