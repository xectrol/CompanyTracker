package com.example.companytracker.controller;

import com.example.companytracker.TestConstants;
import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.controller.dto.UpdateEmployeeDto;
import com.example.companytracker.controller.resource.EmployeeResource;
import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.exception.EmployeeNotFoundException;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import com.example.companytracker.service.EmployeeService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeServiceMock;
    @Mock
    private ConverterService converterServiceMock;

    private EmployeeController underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new EmployeeController(employeeServiceMock, converterServiceMock);
    }

    @Test
    public void shouldGetEmployee() throws EmployeeNotFoundException {
        //GIVEN
        Employee employee = TestUtils.createEmployee();
        EmployeeResource employeeResource = TestUtils.createEmployeeResource();
        Mockito.when(employeeServiceMock.getEmployee(TestConstants.ANY_ID)).thenReturn(employee);
        Mockito.when(converterServiceMock.convert(employee, EmployeeResource.class)).thenReturn(employeeResource);

        //WHEN
        EmployeeResource result = underTest.getEmployee(TestConstants.ANY_ID);

        //THEN
        Assert.assertNotNull(result);
        Assert.assertEquals(result, employeeResource);
    }

    @Test
    public void shouldCreateEmployee() throws DepartmentNotFoundException {
        //Given
        EmployeeDto employeeDto = TestUtils.createEmployeeDto();
        Employee employee = TestUtils.createEmployee();
        EmployeeResource employeeResource = TestUtils.createEmployeeResource();

        when(converterServiceMock.convert(employeeDto, Employee.class)).thenReturn(employee);
        when(employeeServiceMock.saveEmployee(employee)).thenReturn(employee);
        when(converterServiceMock.convert(employee, EmployeeResource.class)).thenReturn(employeeResource);

        //When
        EmployeeResource response = underTest.saveEmployee(employeeDto);

        // THEN
        Assert.assertNotNull(response);
        Assert.assertEquals(response, employeeResource);
    }

    @Test
    public void shouldUpdateEmployee() throws EmployeeNotFoundException, DepartmentNotFoundException {
        //Given
        UpdateEmployeeDto employeeDto = TestUtils.createUpdateEmployeeDto();
        Employee employee = TestUtils.createEmployee();
        EmployeeResource employeeResource = TestUtils.createEmployeeResource();

        when(converterServiceMock.convert(employeeDto, Employee.class)).thenReturn(employee);
        when(employeeServiceMock.updateEmployee(employee)).thenReturn(employee);
        when(converterServiceMock.convert(employee, EmployeeResource.class)).thenReturn(employeeResource);

        //When
        EmployeeResource response = underTest.updateEmployee(employeeDto);

        // THEN
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getFirstName(), employeeResource.getFirstName());
    }

    @Test
    public void shouldDeleteEmployee() throws EmployeeNotFoundException {
        //Given
        doNothing().when(employeeServiceMock).deleteEmployee(TestConstants.ANY_ID);

        //When
        underTest.deleteEmployee(TestConstants.ANY_ID);

        // THEN
        verify(employeeServiceMock, times(1)).deleteEmployee(TestConstants.ANY_ID);
    }
}
