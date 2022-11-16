package com.example.companytracker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private Department department;
    private String email;
}
