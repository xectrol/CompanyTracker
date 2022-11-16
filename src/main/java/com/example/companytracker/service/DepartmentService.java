package com.example.companytracker.service;

import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.exception.EmployeeNotFoundException;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department getDepartment(String departmentId) throws DepartmentNotFoundException {
        log.info("Finding department for the departmentId '{}'...", departmentId);
        Department department = departmentRepository.findById(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found with name : " + departmentId);
        }
        return department;
    }

    public Department saveDepartment(Department department) {
        log.info("Saving department.");
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department departmentModel) throws DepartmentNotFoundException {
        log.info("Update department for  with id '{}'...", departmentId);
        final Department department = departmentRepository.findById(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found with department name : " + departmentId);
        }
        return departmentRepository.save(departmentModel);
    }

    public void deleteDepartment(String departmentId) throws DepartmentNotFoundException {
        log.info("Department with departmentId: {} will be deleted.", departmentId);
        final Department department = departmentRepository.findById(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found with department id : " + departmentId);
        }
        departmentRepository.deleteById(departmentId);
    }
}
