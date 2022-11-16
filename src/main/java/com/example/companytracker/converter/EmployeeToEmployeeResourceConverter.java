package com.example.companytracker.converter;

import com.example.companytracker.controller.resource.EmployeeResource;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeeResourceConverter implements Converter<Employee, EmployeeResource> {
    @Lazy
    @Autowired
    private ConverterService converterService;
    @Override
    public EmployeeResource convert(Employee source) {
        return EmployeeResource.builder()
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .department(converterService.convert(source.getDepartment(), Department.class))
                .birthDate(source.getBirthDate())
                .build();
    }
}
