package com.example.companytracker.converter;

import com.example.companytracker.TestUtils;
import com.example.companytracker.controller.dto.DepartmentDto;
import com.example.companytracker.model.Department;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DepartmentDtoToDepartmentConverterTest {

    @InjectMocks
    private DepartmentDtoToDepartmentConverter underTest;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertDepartmentDtoToDepartment() {
        // GIVEN
        DepartmentDto departmentDto = TestUtils.createDepartmentDto();

        // WHEN
        Department convertedDepartment = underTest.convert(departmentDto);

        //THEN
        assertNotNull(convertedDepartment);
        assertEquals(convertedDepartment.getId(), departmentDto.getId());
        assertEquals(convertedDepartment.getName(), departmentDto.getName());
    }
}
