package com.familyfirstsoftware.departmentManager.service;

import com.familyfirstsoftware.departmentManager.entity.Department;
import com.familyfirstsoftware.departmentManager.repositoryOrDAO.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    //Called once before the tests
    //@BeforeAll
    // called before each and every test case
    @BeforeEach
    void setUp() {
        // build using builder pattern.
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("New York")
                .departmentCode("IT-09")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    // Disable annotation
    //@Disabled
    // changes the display name in console
    @DisplayName("Get Data based on Valid Department Name")
    @Test
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }


}