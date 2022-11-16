package com.example.companytracker.controller;

import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.controller.dto.UpdateEmployeeDto;
import com.example.companytracker.controller.resource.EmployeeResource;
import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.exception.EmployeeNotFoundException;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import com.example.companytracker.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ConverterService converterService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResource getEmployee(@PathVariable String id) throws EmployeeNotFoundException {
        return converterService.convert(employeeService.getEmployee(id), EmployeeResource.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResource saveEmployee(@RequestBody @Valid final EmployeeDto employeeDto) throws DepartmentNotFoundException {
        Employee employee = converterService.convert(employeeDto, Employee.class);
        return converterService.convert(employeeService.saveEmployee(employee), EmployeeResource.class);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResource updateEmployee(@RequestBody @Valid final UpdateEmployeeDto updateEmployeeDto) throws EmployeeNotFoundException, DepartmentNotFoundException {
        Employee employee = employeeService.updateEmployee(converterService.convert(updateEmployeeDto, Employee.class));
        return converterService.convert(employee, EmployeeResource.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String id) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(id);
    }
}
