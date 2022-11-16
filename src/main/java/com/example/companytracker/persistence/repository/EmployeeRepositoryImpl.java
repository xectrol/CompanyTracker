package com.example.companytracker.persistence.repository;

import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.EmployeeRepository;
import com.example.companytracker.persistence.entity.EmployeeEntity;
import com.example.companytracker.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeePostgresRepository employeePostgresRepository;
    private final ConverterService converterService;

    @Override
    public Employee save(Employee employee) {
        return converterService.convert(employeePostgresRepository.save(converterService.convert(employee,
                EmployeeEntity.class)), Employee.class);
    }

    @Override
    public Employee findById(String id) {
        Optional<EmployeeEntity> employeeEntity = employeePostgresRepository.findById(id);
        return employeeEntity.map(entity -> converterService.convert(entity, Employee.class)).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        employeePostgresRepository.deleteById(id);
    }

}
