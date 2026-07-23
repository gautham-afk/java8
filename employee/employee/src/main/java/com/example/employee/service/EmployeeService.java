package com.example.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeRequestDTO;
import com.example.employee.dto.EmployeeResponseDTO;
import com.example.employee.entity.Department;
import com.example.employee.entity.Employee;
import com.example.employee.exception.DepartmentNotFoundException;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.kafka.KafkaProducerService;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.repository.EmployeeRepository;


@Service
public class EmployeeService {

        private final DepartmentRepository departmentRepository;

        public EmployeeService(EmployeeRepository repository,
                        DepartmentRepository departmentRepository,
                        KafkaProducerService kafkaProducerService) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
        this.kafkaProducerService = kafkaProducerService;
        }

        private final EmployeeRepository repository;
        private final KafkaProducerService kafkaProducerService;

        public EmployeeResponseDTO getEmployee(Long id) {

        Employee employee = repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found"));

        return mapToResponse(employee);
        }

        public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable) {

        return repository.findAll(pageable)
                .map(this::mapToResponse);
        }

        public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO dto) {

        Employee employee = mapToEmployee(dto);

        Employee savedEmployee = repository.save(employee);

        kafkaProducerService.sendEmployee(savedEmployee);

        return mapToResponse(savedEmployee);
        }

        public String deleteEmployee(Long id) {

        if (!repository.existsById(id)) {
        throw new EmployeeNotFoundException("Employee not found");
        }

        repository.deleteById(id);

        return "Employee deleted successfully";
        }

        public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId())
        .orElseThrow(() ->
                new DepartmentNotFoundException("Department not found"));

        Employee existingEmployee = repository.findById(id)
        .orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found"));

        existingEmployee.setName(dto.getName());
        existingEmployee.setDepartment(department);

        Employee updated = repository.save(existingEmployee);

        return mapToResponse(updated);
        }

        public List<EmployeeResponseDTO> getEmployeesByDepartment(String department) {

        return repository.findByDepartment_Name(department)
                .stream()
                .map(this::mapToResponse)
                .toList();
        }

        private Employee mapToEmployee(EmployeeRequestDTO dto) {

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found"));

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setDepartment(department);

        return employee;
        }

        private EmployeeResponseDTO mapToResponse(Employee employee) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(employee.getId());
        dto.setName(employee.getName());
        if (employee.getDepartment() != null) {
        dto.setDepartment(employee.getDepartment().getName());
}
        return dto;
        }

}