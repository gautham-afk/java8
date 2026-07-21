package com.example.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.kafka.KafkaProducerService;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final KafkaProducerService kafkaProducerService;

    public EmployeeService(EmployeeRepository repository,
                       KafkaProducerService kafkaProducerService) {
    this.repository = repository;
    this.kafkaProducerService = kafkaProducerService;
    }

    public Employee getEmployee(Long id) {
    return repository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
    return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {

    Employee savedEmployee = repository.save(employee);

    kafkaProducerService.sendEmployee(savedEmployee);

    return savedEmployee;
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

    public List<Employee> getEmployees(String department) {
        return repository.findByDepartment_Name(department);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
    return repository.findByDepartment_Name(department);
    }

}