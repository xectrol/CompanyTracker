package com.example.companytracker.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class UpdateEmployeeDto {
    @NotEmpty(message = "Id cannot be empty!")
    private String id;
    @Size(max = 64)
    private String firstName;
    @Size(max = 64)
    private String lastName;
    private String email;
    private DepartmentDto department;
}
