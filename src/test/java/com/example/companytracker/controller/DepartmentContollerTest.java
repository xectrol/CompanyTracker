package com.example.companytracker.controller;

import com.example.companytracker.TestConstants;
import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.dto.DepartmentDto;
import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.controller.dto.UpdateDepartmentDto;
import com.example.companytracker.controller.dto.UpdateEmployeeDto;
import com.example.companytracker.controller.resource.DepartmentResource;
import com.example.companytracker.controller.resource.EmployeeResource;
import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.exception.EmployeeNotFoundException;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import com.example.companytracker.service.DepartmentService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class DepartmentContollerTest {

    @Mock
    private DepartmentService departmentServiceMock;
    @Mock
    private ConverterService converterServiceMock;

    private DepartmentController underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new DepartmentController(departmentServiceMock, converterServiceMock);
    }

    @Test
    public void shouldGetEmployee() throws EmployeeNotFoundException, DepartmentNotFoundException {
        //GIVEN
        Department department = TestUtils.createDepartment();
        DepartmentResource departmentResource = TestUtils.createDepartmentResource();
        Mockito.when(departmentServiceMock.getDepartment(TestConstants.ANY_ID)).thenReturn(department);
        Mockito.when(converterServiceMock.convert(department, DepartmentResource.class)).thenReturn(departmentResource);

        //WHEN
        DepartmentResource result = underTest.getDepartment(TestConstants.ANY_ID);

        //THEN
        Assert.assertNotNull(result);
        Assert.assertEquals(result, departmentResource);
    }

    @Test
    public void shouldCreateEmployee() throws DepartmentNotFoundException {
        //Given
        DepartmentDto departmentDto = TestUtils.createDepartmentDto();
        Department department = TestUtils.createDepartment();
        DepartmentResource departmentResource = TestUtils.createDepartmentResource();

        when(converterServiceMock.convert(departmentDto, Department.class)).thenReturn(department);
        when(departmentServiceMock.saveDepartment(department)).thenReturn(department);
        when(converterServiceMock.convert(department, DepartmentResource.class)).thenReturn(departmentResource);

        //When
        DepartmentResource response = underTest.saveDepartment(departmentDto);

        // THEN
        Assert.assertNotNull(response);
        Assert.assertEquals(response, departmentResource);
    }

    @Test
    public void shouldUpdateEmployee() throws EmployeeNotFoundException, DepartmentNotFoundException {
        //Given
        UpdateDepartmentDto departmentDto = TestUtils.createUpdateDepartmentDto();
        Department department = TestUtils.createDepartment();
        DepartmentResource departmentResource = TestUtils.createDepartmentResource();

        when(converterServiceMock.convert(departmentDto, Department.class)).thenReturn(department);
        when(departmentServiceMock.updateDepartment(TestConstants.ANY_ID, department)).thenReturn(department);
        when(converterServiceMock.convert(department, DepartmentResource.class)).thenReturn(departmentResource);

        //When
        DepartmentResource response = underTest.updateDepartment(TestConstants.ANY_ID, departmentDto);

        // THEN
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getName(), departmentResource.getName());
    }

    @Test
    public void shouldDeleteEmployee() throws DepartmentNotFoundException {
        //Given
        doNothing().when(departmentServiceMock).deleteDepartment(TestConstants.ANY_ID);

        //When
        underTest.deleteDepartment(TestConstants.ANY_ID);

        // THEN
        verify(departmentServiceMock, times(1)).deleteDepartment(TestConstants.ANY_ID);
    }

}
