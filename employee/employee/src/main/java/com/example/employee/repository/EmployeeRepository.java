package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

                List<Employee> findByDepartment(String department);

                @Query("""
                SELECT e
                FROM Employee e
                WHERE e.department = :department
                """)
                List<Employee> getEmployees(
                @Param("department") String department);


}