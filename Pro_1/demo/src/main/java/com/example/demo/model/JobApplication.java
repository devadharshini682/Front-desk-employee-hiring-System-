package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JobApplication {
@Id
 private Long applicationId;
 private String coverLetter; 
 private String status;
 private String priority;
 private String userId;
 private String jobPositionId;
 public Long getApplicationId() {
    return applicationId;
 }
 public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
 }
 public String getCoverLetter() {
    return coverLetter;
 }
 public void setCoverLetter(String coverLetter) {
    this.coverLetter = coverLetter;
 }
 public String getStatus() {
    return status;
 }
 public void setStatus(String status) {
    this.status = status;
 }
 public String getPriority() {
    return priority;
 }
 public void setPriority(String priority) {
    this.priority = priority;
 }
 public String getUserId() {
    return userId;
 }
 public void setUserId(String userId) {
    this.userId = userId;
 }
 public String getJobPositionId() {
    return jobPositionId;
 }
 public void setJobPositionId(String jobPositionId) {
    this.jobPositionId = jobPositionId;
 }
    
}