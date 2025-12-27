
package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.JobPosition;

public interface JobPositionService {

    JobPosition addJobPosition(JobPosition obj);

    List<JobPosition> getAllJobPositions();

    JobPosition getJobPositionById(Long id);

    JobPosition updateJobPosition(Long id, JobPosition obj);

    Page<JobPosition> getJobPositionsWithPagination(int page, int size);
}
