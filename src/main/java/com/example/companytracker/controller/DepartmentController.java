package com.example.companytracker.controller;

import com.example.companytracker.controller.dto.DepartmentDto;
import com.example.companytracker.controller.dto.UpdateDepartmentDto;
import com.example.companytracker.controller.resource.DepartmentResource;
import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.model.Department;
import com.example.companytracker.service.ConverterService;
import com.example.companytracker.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final ConverterService converterService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentResource getDepartment(@PathVariable String id) throws DepartmentNotFoundException {
        return converterService.convert(departmentService.getDepartment(id), DepartmentResource.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentResource saveDepartment(@RequestBody @Valid final DepartmentDto departmentDto) {
        Department department = departmentService.saveDepartment(converterService.convert(departmentDto, Department.class));
        return converterService.convert(department, DepartmentResource.class);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentResource updateDepartment(@PathVariable String id, @RequestBody @Valid final UpdateDepartmentDto updateDepartmentDto) throws DepartmentNotFoundException {
         Department department = departmentService.updateDepartment(id, converterService.convert(updateDepartmentDto, Department.class));
         return converterService.convert(department, DepartmentResource.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable String id) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(id);
    }

}
