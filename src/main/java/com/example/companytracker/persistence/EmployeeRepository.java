package com.example.companytracker.persistence;

import com.example.companytracker.model.Employee;

public interface EmployeeRepository {
    Employee save(Employee employee);

    Employee findById(String id);

    void deleteById(String id);
}
