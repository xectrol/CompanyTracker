package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.dto.DepartmentDto;
import com.example.companytracker.model.Department;
import com.example.companytracker.persistence.entity.DepartmentEntity;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DepartmentEntityToDepartmentConverterTest {

    @InjectMocks
    private DepartmentEntityToDepartmentConverter underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertDepartmentEntityToDepartment() {
        // GIVEN
        DepartmentEntity departmentEntity = TestUtils.createDepartmentEntity();

        // WHEN
        Department convertedDepartment = underTest.convert(departmentEntity);

        //THEN
        assertNotNull(convertedDepartment);
        assertEquals(convertedDepartment.getId(), departmentEntity.getDepartmentId());
        assertEquals(convertedDepartment.getName(), departmentEntity.getName());
    }
}
