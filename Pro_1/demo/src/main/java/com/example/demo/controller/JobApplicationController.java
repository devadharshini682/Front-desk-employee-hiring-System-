
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/job-applications")
public class JobApplicationController {

    private List<String> applications = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> createJobApplication(
            @RequestBody(required = false) String body) {

        if (body == null) {
            return ResponseEntity.badRequest().build();
        }

        applications.add(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllJobApplications() {

        if (applications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getJobApplicationById(@PathVariable int id) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Job application not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobApplication(
            @PathVariable int id,
            @RequestBody(required = false) String body) {

        if (id < 0 || id >= applications.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        applications.set(id, body);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobApplication(@PathVariable int id) {

        if (id < 0 || id >= applications.size()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        applications.remove(id);
        return ResponseEntity.ok().build();
    }
}
