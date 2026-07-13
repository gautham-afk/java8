package com.example.employee.controller;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee")
    public Employee getEmployee() {
        return service.getEmployee();
    }

    @GetMapping("/employee/new")
    public Employee employee() {

        return new Employee(
                1,
                "Gautham",
                "IT");
    }

    @GetMapping("/employee/all")
    public List<Employee> employees() {
        return List.of(
                new Employee(1, "Gautham", "IT"),
                new Employee(2, "John", "HR"),
                new Employee(3, "Jane", "Finance")
        );
    }

    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable int id) {
        return "Employee ID : " + id;
    }

    @GetMapping("/employee/{department}/{id}")
    public String employee(
            @PathVariable String department,
            @PathVariable int id) {

        return department + " " + id;
    }

    @GetMapping("/employee/search")
    public String search(
            @RequestParam String name) {

        return "Searching : " + name;
    }

    @GetMapping("/employee/filter")
    public String filter(
            @RequestParam String department,
            @RequestParam int age) {

        return department + " " + age;
    }

    @PostMapping("/employee")
    public Employee saveEmployee(
            @RequestBody Employee employee) {

        return employee;
    }
    @PutMapping("/employee/{id}")
    public String updateEmployee(
            @PathVariable int id) {

        return "Employee Updated : " + id;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(
            @PathVariable int id) {

        return "Employee Deleted : " + id;
    }



}