
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobPosition;
import com.example.demo.repository.JobPositionRepository;

@Service
public class JobPositionServiceImpl implements JobPositionService {

    @Autowired
    private JobPositionRepository jobPositionRepository;

    @Override
    public JobPosition addJobPosition(JobPosition obj) {
        return jobPositionRepository.save(obj);
    }

    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionRepository.findAll();
    }

    @Override
    public JobPosition getJobPositionById(Long id) {
        return jobPositionRepository.findById(id).orElse(null);
    }

    @Override
    public JobPosition updateJobPosition(Long id, JobPosition obj) {
        return jobPositionRepository.findById(id).map(existing -> {
            existing.setPositionTitle(obj.getPositionTitle());
            existing.setDescription(obj.getDescription());
            existing.setLocation(obj.getLocation());
            existing.setExperienceRequired(obj.getExperienceRequired());
            existing.setOpenings(obj.getOpenings());
            existing.setDepartment(obj.getDepartment());
            return jobPositionRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public Page<JobPosition> getJobPositionsWithPagination(int page, int size) {
        return jobPositionRepository.findAll(PageRequest.of(page, size));
    }
}
