package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.model.Department;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DepartmentToDepartmentEntityConverterTest {

    @InjectMocks
    private DepartmentToDepartmentEntityConverter underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertDepartmentToDepartmentEntity() {
        // GIVEN
        Department department = TestUtils.createDepartment();

        // WHEN
        DepartmentEntity convertedDepartment = underTest.convert(department);

        //THEN
        assertNotNull(convertedDepartment);
        assertEquals(convertedDepartment.getDepartmentId(), department.getId());
        assertEquals(convertedDepartment.getName(), department.getName());
    }
}
