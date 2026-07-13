package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee getEmployee() {
        return repository.findEmployee();
    }
}