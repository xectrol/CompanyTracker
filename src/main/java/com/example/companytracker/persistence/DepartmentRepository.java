package com.example.companytracker.persistence;

import com.example.companytracker.model.Department;

public interface DepartmentRepository {
    Department save(Department department);

    Department findById(String id);

    void deleteById(String id);
}
