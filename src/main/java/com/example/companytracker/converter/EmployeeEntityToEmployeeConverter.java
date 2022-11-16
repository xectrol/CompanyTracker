package com.example.companytracker.converter;

import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.entity.EmployeeEntity;
import com.example.companytracker.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityToEmployeeConverter implements Converter<EmployeeEntity, Employee> {
    @Lazy
    @Autowired
    private ConverterService converterService;

    @Override
    public Employee convert(EmployeeEntity source) {
        return Employee.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .department(converterService.convert(source.getDepartment(), Department.class))
                .email(source.getEmail())
                .birthDate(source.getBirthDate())
                .build();
    }
}
