package com.example.companytracker.service;

import com.example.companytracker.TestConstants;
import com.example.companytracker.TestUtils;
import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.exception.EmployeeNotFoundException;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.DepartmentRepository;
import com.example.companytracker.persistence.EmployeeRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNotNull;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepositoryMock;

    @Mock
    private DepartmentRepository departmentRepositoryMock;

    private EmployeeService underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new EmployeeService(employeeRepositoryMock, departmentRepositoryMock);
    }

    @Test(expectedExceptions = EmployeeNotFoundException.class)
    public void shouldGetEmployeeNotFoundExceptionWhenEmployeeNotFound() throws EmployeeNotFoundException {
        //GIVEN

        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Employee response = underTest.getEmployee(TestConstants.ANY_ID);

        //THEN
        assertNotNull(response);
    }

    @Test
    public void shouldGetEmployee() throws EmployeeNotFoundException {
        //GIVEN
        Employee employee = TestUtils.createEmployee();
        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(employee);

        //WHEN
        Employee response = underTest.getEmployee(TestConstants.ANY_ID);

        //THEN
        assertNotNull(response);
        verify(employeeRepositoryMock, times(1)).findById(employee.getId());
    }

    @Test
    public void shouldDeleteEmployee() throws EmployeeNotFoundException {
        //GIVEN
        Employee employee = TestUtils.createEmployee();

        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(employee);
        doNothing().when(employeeRepositoryMock).deleteById(employee.getId());

        //WHEN
        underTest.deleteEmployee(TestConstants.ANY_ID);

        //THEN
        verify(employeeRepositoryMock, times(1)).deleteById(employee.getId());
    }

    @Test(expectedExceptions = EmployeeNotFoundException.class)
    public void shouldThrowEmployeeNotFoundExceptionWhenDeletingEmployee() throws EmployeeNotFoundException {
        //GIVEN

        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Employee response = underTest.getEmployee(TestConstants.ANY_ID);

        //THEN
        assertNotNull(response);
    }

    @Test
    public void shouldSaveEmployee() throws EmployeeNotFoundException, DepartmentNotFoundException {

        //GIVEN
        Employee employee = TestUtils.createEmployee();
        Department department = TestUtils.createDepartment();
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(department);
        when(employeeRepositoryMock.save(employee)).thenReturn(employee);
        //WHEN
        Employee response = underTest.saveEmployee(employee);

        //THEN
        assertNotNull(response);
        verify(departmentRepositoryMock, times(1)).findById(employee.getId());
        verify(employeeRepositoryMock, times(1)).save(employee);
    }

    @Test(expectedExceptions = DepartmentNotFoundException.class)
    public void shouldGetDepartmentNotFoundExceptionWhenDepartmentNotFound() throws DepartmentNotFoundException {
        //GIVEN
        Employee employee = TestUtils.createEmployee();
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Employee response = underTest.saveEmployee(employee);

        //THEN
        assertNotNull(response);
    }

    @Test
    public void shouldUpdateEmployee() throws EmployeeNotFoundException, DepartmentNotFoundException {

        //GIVEN
        Employee employee = TestUtils.createEmployee();
        Department department = TestUtils.createDepartment();
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(department);
        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(employee);
        when(employeeRepositoryMock.save(employee)).thenReturn(employee);
        //WHEN
        Employee response = underTest.updateEmployee(employee);

        //THEN
        assertNotNull(response);
        verify(departmentRepositoryMock, times(1)).findById(employee.getId());
        verify(employeeRepositoryMock, times(1)).save(employee);
    }

    @Test(expectedExceptions = DepartmentNotFoundException.class)
    public void shouldThrowDepartmentNotFoundExceptionWhenUpdatingEmployee() throws DepartmentNotFoundException, EmployeeNotFoundException {
        //GIVEN
        Employee employee = TestUtils.createEmployee();
        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(employee);
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Employee response = underTest.updateEmployee(employee);

        //THEN
        assertNotNull(response);
    }

    @Test(expectedExceptions = EmployeeNotFoundException.class)
    public void shouldThrowEmployeeNotFoundExceptionWhenUpdatingEmployee() throws DepartmentNotFoundException, EmployeeNotFoundException {
        //GIVEN
        Employee employee = TestUtils.createEmployee();
        when(employeeRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Employee response = underTest.updateEmployee(employee);

        //THEN
        assertNotNull(response);
    }

}
