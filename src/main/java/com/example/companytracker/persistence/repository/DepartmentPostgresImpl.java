package com.example.companytracker.persistence.repository;

import com.example.companytracker.model.Department;
import com.example.companytracker.persistence.DepartmentRepository;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import com.example.companytracker.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DepartmentPostgresImpl implements DepartmentRepository {
    private final DepartmentPostgresRepository departmentPostgresRepository;
    private final ConverterService converterService;

    @Override
    public Department save(Department department) {
        return converterService.convert(departmentPostgresRepository.save(converterService.convert(department,
                DepartmentEntity.class)), Department.class);
    }

    @Override
    public Department findById(String id) {
        Optional<DepartmentEntity> departmentEntity = departmentPostgresRepository.findById(id);
        return departmentEntity.map(entity -> converterService.convert(entity, Department.class)).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        departmentPostgresRepository.deleteById(id);
    }
}
