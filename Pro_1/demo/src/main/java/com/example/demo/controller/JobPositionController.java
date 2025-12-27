
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.JobPosition;
import com.example.demo.service.JobPositionService;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

    @Autowired
    private JobPositionService jobPositionService;

    @PostMapping
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPositionService.addJobPosition(obj));
    }

    @GetMapping
    public List<JobPosition> getAllJobPositions(){
        return jobPositionService.getAllJobPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id){
        JobPosition obj = jobPositionService.getJobPositionById(id);
        if(obj==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition obj){
        JobPosition updated = jobPositionService.updateJobPosition(id, obj);
        if(updated==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/search/{keyword}")
    public List<JobPosition> searchJobPositions(@PathVariable String keyword){
        return jobPositionService.getAllJobPositions().stream()
                .filter(p -> p.getPositionTitle().contains(keyword))
                .toList();
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<JobPosition>> getJobPositionsWithPagination(@PathVariable int page, @PathVariable int size){
        Page<JobPosition> paged = jobPositionService.getJobPositionsWithPagination(page, size);
        return ResponseEntity.ok(paged);
    }
}
