package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.persistence.entity.EmployeeEntity;
import com.example.companytracker.service.ConverterService;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmployeeEntityToEmployeeConverterTest {

    @InjectMocks
    private EmployeeEntityToEmployeeConverter underTest;

    @Mock
    private ConverterService converterServiceMock;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertAgreementEntityToAgreement() {
        final EmployeeEntity employeeEntity = TestUtils.createEmployeeEntity();

        Mockito.when(converterServiceMock.convert(employeeEntity.getDepartment(), Department.class)).thenReturn(TestUtils.createDepartment());

        final Employee convertedAgreement = underTest.convert(employeeEntity);
        Assert.assertNotNull(convertedAgreement);
        Assert.assertEquals(convertedAgreement.getId(), employeeEntity.getId());
        Assert.assertEquals(convertedAgreement.getDepartment().getId(), employeeEntity.getDepartment().getDepartmentId());
        Assert.assertEquals(convertedAgreement.getDepartment().getName(), employeeEntity.getDepartment().getName());
        Assert.assertEquals(convertedAgreement.getEmail(), employeeEntity.getEmail());
        Assert.assertEquals(convertedAgreement.getBirthDate(), employeeEntity.getBirthDate());
        Assert.assertEquals(convertedAgreement.getFirstName(), employeeEntity.getFirstName());
        Assert.assertEquals(convertedAgreement.getLastName(), employeeEntity.getLastName());
    }

}
