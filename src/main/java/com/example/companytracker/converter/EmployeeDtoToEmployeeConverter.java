package com.example.companytracker.converter;

import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoToEmployeeConverter implements Converter<EmployeeDto, Employee> {

    @Lazy
    @Autowired
    private ConverterService converterService;

    @Override
    public Employee convert(EmployeeDto source) {
        return Employee.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .birthDate(source.getBirthDate())
                .department(converterService.convert(source.getDepartment(), Department.class))
                .build();
    }
}
