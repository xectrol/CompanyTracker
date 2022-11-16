package com.example.companytracker.service;

import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.exception.EmployeeNotFoundException;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.DepartmentRepository;
import com.example.companytracker.persistence.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    public Employee getEmployee(String employeeId) throws EmployeeNotFoundException {
        log.info("Finding employee for the employeeId '{}'...", employeeId);
        Employee employee = employeeRepository.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with id : " + employeeId);
        }
        return employee;
    }

    public Employee saveEmployee(Employee employee) throws DepartmentNotFoundException {
        log.info("Saving employee.");
        String departmentId = employee.getDepartment().getId();
        Department department = departmentRepository.findById(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found with id : " + departmentId);
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employeeModel) throws EmployeeNotFoundException, DepartmentNotFoundException {
        log.info("Update employee for department with id '{}'...", employeeModel.getId());
        final Employee employee = employeeRepository.findById(employeeModel.getId());
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with department id : " + employeeModel.getId());
        }
        String departmentId = employeeModel.getDepartment().getId();
        Department department = departmentRepository.findById(departmentId);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found with id : " + departmentId);
        }
        employee.setEmail(employeeModel.getEmail());
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());
        employee.setDepartment(employeeModel.getDepartment());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeeId) throws EmployeeNotFoundException {
        log.info("Employee with employeeId: {} will be deleted.", employeeId);
        final Employee employee = employeeRepository.findById(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found with department id : " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }
}
