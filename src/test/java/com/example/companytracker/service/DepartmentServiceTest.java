package com.example.companytracker.service;

import com.example.companytracker.TestConstants;
import com.example.companytracker.TestUtils;
import com.example.companytracker.exception.DepartmentNotFoundException;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.DepartmentRepository;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNotNull;

public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepositoryMock;

    private DepartmentService underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new DepartmentService(departmentRepositoryMock);
    }

    @Test(expectedExceptions = DepartmentNotFoundException.class)
    public void shouldGetDepartmentNotFoundExceptionWhenDepartmentNotFound() throws DepartmentNotFoundException {
        //GIVEN

        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Department response = underTest.getDepartment(TestConstants.ANY_ID);

        //THEN
        assertNotNull(response);
    }

    @Test
    public void shouldGetDepartment() throws DepartmentNotFoundException {
        //GIVEN
        Department department = TestUtils.createDepartment();
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(department);

        //WHEN
        Department response = underTest.getDepartment(TestConstants.ANY_ID);

        //THEN
        assertNotNull(response);
        verify(departmentRepositoryMock, times(1)).findById(department.getId());
    }

    @Test
    public void shouldDeleteDepartment() throws DepartmentNotFoundException {
        //GIVEN
        Department employee = TestUtils.createDepartment();

        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(employee);
        doNothing().when(departmentRepositoryMock).deleteById(employee.getId());

        //WHEN
        underTest.deleteDepartment(TestConstants.ANY_ID);

        //THEN
        verify(departmentRepositoryMock, times(1)).deleteById(employee.getId());
    }

    @Test(expectedExceptions = DepartmentNotFoundException.class)
    public void shouldThrowDepartmentNotFoundExceptionWhenDeletingDepartment() throws DepartmentNotFoundException {
        //GIVEN

        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Department response = underTest.getDepartment(TestConstants.ANY_ID);

        //THEN
        assertNotNull(response);
    }

    @Test
    public void shouldSaveDepartment() {

        //GIVEN
        Department department = TestUtils.createDepartment();
        when(departmentRepositoryMock.save(department)).thenReturn(department);
        //WHEN
        Department response = underTest.saveDepartment(department);

        //THEN
        assertNotNull(response);
        verify(departmentRepositoryMock, times(1)).save(department);
    }


    @Test
    public void shouldUpdateDepartment() throws DepartmentNotFoundException {

        //GIVEN
        Employee employee = TestUtils.createEmployee();
        Department department = TestUtils.createDepartment();
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(department);
        when(departmentRepositoryMock.save(department)).thenReturn(department);
        //WHEN
        Department response = underTest.updateDepartment(TestConstants.ANY_ID, department);

        //THEN
        assertNotNull(response);
        verify(departmentRepositoryMock, times(1)).findById(employee.getId());
    }

    @Test(expectedExceptions = DepartmentNotFoundException.class)
    public void shouldThrowDepartmentNotFoundExceptionWhenUpdatingDepartment() throws DepartmentNotFoundException {
        //GIVEN
        Department department = TestUtils.createDepartment();
        when(departmentRepositoryMock.findById(TestConstants.ANY_ID)).thenReturn(null);

        //WHEN
        Department response = underTest.updateDepartment(TestConstants.ANY_ID, department);

        //THEN
        assertNotNull(response);
    }
}
