package com.example.companytracker.controller.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    @Size(max = 255)
    @NotEmpty(message = "DepartmentId cannot be empty!")
    private String id;
    @Size(max = 255)
    @NotEmpty(message = "Department cannot be empty!")
    private String name;
}
