package com.example.companytracker.converter;

import com.example.companytracker.model.Department;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentToDepartmentEntityConverter implements Converter<Department, DepartmentEntity> {

    @Override
    public DepartmentEntity convert(Department source) {
        return DepartmentEntity.builder()
                .departmentId(source.getId())
                .name(source.getName())
                .build();
    }

}
