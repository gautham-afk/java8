package com.example.employee.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30)
    private String name;

    @NotNull(message = "Department Id is required")
    private Long departmentId;

    public EmployeeRequestDTO() {
    }

    public EmployeeRequestDTO(String name, Long departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}