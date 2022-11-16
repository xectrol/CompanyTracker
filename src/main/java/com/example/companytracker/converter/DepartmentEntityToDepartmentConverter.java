package com.example.companytracker.converter;

import com.example.companytracker.model.Department;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentEntityToDepartmentConverter implements Converter<DepartmentEntity, Department>{
    @Override
    public Department convert(DepartmentEntity source) {
        return Department.builder()
                .id(source.getDepartmentId())
                .name(source.getName())
                .build();
    }
}
