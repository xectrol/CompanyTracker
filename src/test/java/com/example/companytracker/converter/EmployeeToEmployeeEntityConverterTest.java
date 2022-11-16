package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import com.example.companytracker.persistence.entity.EmployeeEntity;
import com.example.companytracker.service.ConverterService;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeToEmployeeEntityConverterTest {

    @InjectMocks
    private EmployeeToEmployeeEntityConverter underTest;

    @Mock
    private ConverterService converterServiceMock;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertEmployeeToEmployeeEntityConverter() {
        final Employee employee = TestUtils.createEmployee();

        Mockito.when(converterServiceMock.convert(employee.getDepartment(), DepartmentEntity.class)).thenReturn(TestUtils.createDepartmentEntity());

        final EmployeeEntity convertedAgreement = underTest.convert(employee);
        Assert.assertNotNull(convertedAgreement);
        Assert.assertEquals(convertedAgreement.getId(), employee.getId());
        Assert.assertEquals(convertedAgreement.getDepartment().getName(), employee.getDepartment().getName());
        Assert.assertEquals(convertedAgreement.getEmail(), employee.getEmail());
        Assert.assertEquals(convertedAgreement.getBirthDate(), employee.getBirthDate());
        Assert.assertEquals(convertedAgreement.getFirstName(), employee.getFirstName());
        Assert.assertEquals(convertedAgreement.getLastName(), employee.getLastName());
    }
}
