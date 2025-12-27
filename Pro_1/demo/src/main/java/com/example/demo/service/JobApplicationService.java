package com.example.demo.service;

import java.util.List;

public interface JobApplicationService {
    Object addJobApplication(Object obj);
    List<Object> getAllJobApplications();
    Object getJobApplicationById(int id);
    Object updateJobApplication(int id, Object obj);
    boolean deleteJobApplication(int id);
}
