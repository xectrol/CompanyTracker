package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.resource.DepartmentResource;
import com.example.companytracker.model.Department;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DepartmentToDepartmentResourceConverterTest {


    @InjectMocks
    private DepartmentToDepartmentResourceConverter underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertDepartmentToDepartmentResourceConverter() {
        // GIVEN
        Department department = TestUtils.createDepartment();

        // WHEN
        DepartmentResource convertedDepartment = underTest.convert(department);

        //THEN
        assertNotNull(convertedDepartment);
        assertEquals(convertedDepartment.getName(), department.getName());
    }

}
