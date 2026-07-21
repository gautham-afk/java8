package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Department;
import com.example.employee.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartment(Long id) {
        return repository.findById(id).orElse(null);
    }
}