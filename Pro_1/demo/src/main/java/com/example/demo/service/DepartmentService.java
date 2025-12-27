
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Department;

public interface DepartmentService {
    Department addDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
}
