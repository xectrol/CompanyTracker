package com.example.companytracker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Builder
public class Department {
    private String id;
    private String name;
}
