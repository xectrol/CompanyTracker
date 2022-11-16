package com.example.companytracker.converter;

import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import com.example.companytracker.persistence.entity.EmployeeEntity;
import com.example.companytracker.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeToEmployeeEntityConverter implements Converter<Employee, EmployeeEntity> {
    @Lazy
    @Autowired
    private ConverterService converterService;
    @Override
    public EmployeeEntity convert(Employee source) {
        return EmployeeEntity.builder()
                .id(source.getId())
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .department(converterService.convert(source.getDepartment(), DepartmentEntity.class))
                .birthDate(source.getBirthDate())
                .build();
    }
}
