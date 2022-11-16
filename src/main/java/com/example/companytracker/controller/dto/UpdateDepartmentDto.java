package com.example.companytracker.controller.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UpdateDepartmentDto {
    private String id;
    private String name;
}
