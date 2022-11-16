package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.dto.EmployeeDto;
import com.example.companytracker.controller.dto.UpdateEmployeeDto;
import com.example.companytracker.model.Department;
import com.example.companytracker.model.Employee;
import com.example.companytracker.service.ConverterService;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateEmployeeDtoToEmployeeConverterTest {

    @InjectMocks
    private UpdateEmployeeDtoToEmployeeConverter underTest;

    @Mock
    private ConverterService converterServiceMock;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertUpdateEmployeeDtoToEmployeeConverter() {
        final UpdateEmployeeDto employeeDto = TestUtils.createUpdateEmployeeDto();

        Mockito.when(converterServiceMock.convert(employeeDto.getDepartment(), Department.class)).thenReturn(TestUtils.createDepartment());

        final Employee convertedAgreement = underTest.convert(employeeDto);
        Assert.assertNotNull(convertedAgreement);
        Assert.assertEquals(convertedAgreement.getId(), employeeDto.getId());
        Assert.assertEquals(convertedAgreement.getDepartment().getName(), employeeDto.getDepartment().getName());
        Assert.assertEquals(convertedAgreement.getEmail(), employeeDto.getEmail());
        Assert.assertEquals(convertedAgreement.getFirstName(), employeeDto.getFirstName());
        Assert.assertEquals(convertedAgreement.getLastName(), employeeDto.getLastName());
    }

}
