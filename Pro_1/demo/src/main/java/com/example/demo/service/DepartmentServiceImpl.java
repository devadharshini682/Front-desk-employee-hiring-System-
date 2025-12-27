
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepo;

    public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> dept = departmentRepo.findById(id);
        return dept.orElse(null);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Optional<Department> existing = departmentRepo.findById(id);
        if (existing.isEmpty()) return null;

        Department d = existing.get();
        d.setDepartmentName(department.getDepartmentName());
        d.setContactEmail(department.getContactEmail());
        d.setContactPhone(department.getContactPhone());
        return departmentRepo.save(d);
    }

    // Pagination helper for Day 9
    public Page<Department> getDepartmentsPage(int page, int size) {
        return departmentRepo.findAll(PageRequest.of(page, size));
    }
}

