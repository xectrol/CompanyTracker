package com.example.companytracker.controller.resource;

import com.example.companytracker.model.Department;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import static com.example.companytracker.Constants.DATE_FORMAT;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResource {
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = DATE_FORMAT)
    @JsonFormat(pattern = DATE_FORMAT)
    private String birthDate;
    private Department department;
    private String email;
}
