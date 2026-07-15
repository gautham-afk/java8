package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee getEmployee(Long id) {
    return repository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
    return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
    return repository.save(employee);
    }

    public String deleteEmployee(Long id) {

    if (!repository.existsById(id)) {
        return "Employee not found";
    }

    repository.deleteById(id);

    return "Employee deleted successfully";
    }

    public Employee updateEmployee(Long id, Employee employee) {

    Employee existingEmployee = repository.findById(id)
            .orElse(null);

    if (existingEmployee == null) {
        return null;
    }

    existingEmployee.setName(employee.getName());
    existingEmployee.setDepartment(employee.getDepartment());

    return repository.save(existingEmployee);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
    return repository.findByDepartment(department);
    }

    public List<Employee> getEmployees(String department) {
        return repository.getEmployees(department); 
    }

}