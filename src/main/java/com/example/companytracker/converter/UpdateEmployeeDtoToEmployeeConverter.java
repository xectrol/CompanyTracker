package com.example.companytracker.converter;

import com.example.companytracker.controller.dto.UpdateEmployeeDto;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmployeeDtoToEmployeeConverter implements Converter<UpdateEmployeeDto, Employee> {

    @Lazy
    @Autowired
    private ConverterService converterService;

    @Override
    public Employee convert(UpdateEmployeeDto source) {
        return Employee.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .email(source.getEmail())
                .department(converterService.convert(source.getDepartment(), Department.class))
                .build();
    }
}
