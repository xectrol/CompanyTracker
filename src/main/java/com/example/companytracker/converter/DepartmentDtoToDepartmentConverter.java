package com.example.companytracker.converter;

import com.example.companytracker.controller.dto.DepartmentDto;
import com.example.companytracker.model.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDtoToDepartmentConverter implements Converter<DepartmentDto, Department> {
    @Override
    public Department convert(DepartmentDto source) {
        return Department.builder()
                .name(source.getName())
                .id(source.getId())
                .build();
    }
}
