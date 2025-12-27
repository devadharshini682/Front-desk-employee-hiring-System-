package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private List<Object> jobApplications = new ArrayList<>();

    @Override
    public Object addJobApplication(Object obj) {
        jobApplications.add(obj);
        return obj;
    }

    @Override
    public List<Object> getAllJobApplications() {
        return jobApplications;
    }

    @Override
    public Object getJobApplicationById(int id) {
        if(id < 0 || id >= jobApplications.size()) return null;
        return jobApplications.get(id);
    }

    @Override
    public Object updateJobApplication(int id, Object obj) {
        if(id < 0 || id >= jobApplications.size()) return null;
        jobApplications.set(id, obj);
        return obj;
    }

    @Override
    public boolean deleteJobApplication(int id) {
        if(id < 0 || id >= jobApplications.size()) return false;
        jobApplications.remove(id);
        return true;
    }
}
