package com.example.employee.controller;
import java.util.List;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee.dto.EmployeeRequestDTO;
import com.example.employee.dto.EmployeeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployee(@PathVariable Long id) {
        return service.getEmployee(id);
    }

    @GetMapping
    public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable) {

        return service.getAllEmployees(pageable);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO dto) {

        return service.updateEmployee(id, dto);
    }

    @GetMapping("/search")
    public String search(@RequestParam String name) {
        return "Searching : " + name;
    }

    @GetMapping("/filter")
    public String filter(
            @RequestParam String department,
            @RequestParam int age) {

        return department + " " + age;
    }

    @PostMapping
    public EmployeeResponseDTO save(
            @Valid @RequestBody EmployeeRequestDTO dto) {

        return service.saveEmployee(dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return service.deleteEmployee(id);
    }

    @GetMapping("/department/{department}")
    public List<EmployeeResponseDTO> getEmployeesByDepartment(
            @PathVariable String department) {

        return service.getEmployeesByDepartment(department);
    } 
}