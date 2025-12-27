
package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.InterviewFeedbackService;

@RestController
@RequestMapping("/api")
public class InterviewFeedbackController {

    private final InterviewFeedbackService service;

    public InterviewFeedbackController(InterviewFeedbackService service) {
        this.service = service;
    }

    @PostMapping("/interview-feedbacks")
    public ResponseEntity<Object> addInterviewFeedback(@RequestBody(required = false) Object feedback) {
        if (feedback == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addFeedback(feedback));
    }

    @GetMapping("/interview-feedbacks")
    public ResponseEntity<List<Object>> getAllInterviewFeedbacks() {
        List<Object> list = service.getAllFeedbacks();
        if (list.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/interview-feedbacks/{id}")
    public ResponseEntity<Object> getInterviewFeedbackById(@PathVariable Long id) {
        List<Object> list = service.getAllFeedbacks();
        if (list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list.get(0));
    }

    @PutMapping("/interview-feedbacks/{id}")
    public ResponseEntity<Object> updateInterviewFeedback(@PathVariable Long id,
                                                          @RequestBody Object feedback) {
        return ResponseEntity.ok(feedback);
    }

   
    @GetMapping("/jobapplications/{id}/feedbacks")
    public ResponseEntity<List<Object>> getFeedbacksByJobApplication(@PathVariable Long id) {
        List<Object> list = service.getAllFeedbacks();

        List<Object> filtered = list.stream().filter(f -> {
            try {
                var field = f.getClass().getDeclaredField("jobApplicationId");
                field.setAccessible(true);
                Object value = field.get(f);
                return value != null && value.equals(id);
            } catch (Exception e) {
                return false;
            }
        }).collect(Collectors.toList());

        if (filtered.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(filtered);
    }
}
