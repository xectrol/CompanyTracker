package com.example.companytracker.converter;

import com.example.companytracker.controller.dto.UpdateDepartmentDto;
import com.example.companytracker.model.Department;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UpdateDepartmentDtoToDepartmentConverter implements Converter<UpdateDepartmentDto, Department> {
    @Override
    public Department convert(UpdateDepartmentDto source) {
        return Department.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
