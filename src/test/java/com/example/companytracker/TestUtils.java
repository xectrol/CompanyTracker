package com.example.companytracker;

import com.example.companytracker.controller.dto.DepartmentDto;
import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.controller.dto.UpdateDepartmentDto;
import com.example.companytracker.controller.dto.UpdateEmployeeDto;
import com.example.companytracker.controller.resource.DepartmentResource;
import com.example.companytracker.controller.resource.EmployeeResource;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import com.example.companytracker.persistence.entity.EmployeeEntity;

import static com.example.companytracker.TestConstants.*;

public class TestUtils {

    public static Employee createEmployee() {
        return Employee.builder().id(ANY_ID).email(ANY_EMAIL).firstName(ANY_NAME).lastName(ANY_LAST_NAME).department(createDepartment()).build();
    }

    public static EmployeeEntity createEmployeeEntity() {
        return EmployeeEntity.builder().id(ANY_ID).email(ANY_EMAIL).firstName(ANY_NAME).lastName(ANY_LAST_NAME).department(createDepartmentEntity()).build();
    }

    public static EmployeeDto createEmployeeDto() {
        return EmployeeDto.builder().id(ANY_ID).email(ANY_EMAIL).firstName(ANY_NAME).lastName(ANY_LAST_NAME).department(createDepartmentDto()).build();
    }

    public static UpdateEmployeeDto createUpdateEmployeeDto() {
        return UpdateEmployeeDto.builder().id(ANY_ID).email(ANY_EMAIL).firstName(ANY_NAME).lastName(ANY_LAST_NAME).department(createDepartmentDto()).build();
    }

    public static EmployeeResource createEmployeeResource() {
        return EmployeeResource.builder().email(ANY_EMAIL).firstName(ANY_NAME).lastName(ANY_LAST_NAME).department(createDepartment()).build();
    }

    public static Department createDepartment() {
        return Department.builder().id(ANY_ID).name(ANY_NAME).build();
    }

    public static DepartmentDto createDepartmentDto() {
        return DepartmentDto.builder().id(ANY_ID).name(ANY_NAME).build();
    }

    public static DepartmentEntity createDepartmentEntity() {
        return DepartmentEntity.builder().departmentId(ANY_ID).name(ANY_NAME).build();
    }

    public static UpdateDepartmentDto createUpdateDepartmentDto() {
        return UpdateDepartmentDto.builder().id(ANY_ID).name(ANY_NAME).build();
    }

    public static DepartmentResource createDepartmentResource() {
        return DepartmentResource.builder().name(ANY_NAME).build();
    }

}
