package com.example.companytracker.converter;

import com.example.companytracker.controller.resource.DepartmentResource;
import com.example.companytracker.model.Department;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class DepartmentToDepartmentResourceConverter implements Converter<Department, DepartmentResource> {

    @Override
    public DepartmentResource convert(Department source) {
        return DepartmentResource.builder()
                .name(source.getName())
                .build();
    }
}
