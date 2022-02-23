package com.familyfirstsoftware.departmentManager.controller;

import com.familyfirstsoftware.departmentManager.entity.Department;
import com.familyfirstsoftware.departmentManager.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    // autowires the spring bean
    @Autowired
    private DepartmentService departmentService;

    // Logger
    private final Logger LOGGER = LoggerFactory.getLogger("DepartmentController.class");

    /*
        takes json object as request-body then calls the service layer to
         converts it to our department entity

         @Valid checks to make sure it is valid with the rules in the Department entity fields
     */
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList(){
        LOGGER.info("Inside getDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @DeleteMapping("/departments")
    public Department deleteDepartment(@RequestParam Department department){
        return departmentService.deleteDepartment(department);
    }

    // {id} defines path variable
    // to get in postman you must pass /departments/{id} so /departments/1
    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){

        return departmentService.fetchDepartmentById(id);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteById(id);
        return "Department deleted Successfully!!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(id, department);

    }
    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
