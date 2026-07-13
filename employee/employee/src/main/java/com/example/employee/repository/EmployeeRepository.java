package com.example.employee.repository;

import com.example.employee.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    public Employee findEmployee() {

        return new Employee(
                1,
                "Gautham",
                "IT");
    }

}