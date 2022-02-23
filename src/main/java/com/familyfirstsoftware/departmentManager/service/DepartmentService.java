package com.familyfirstsoftware.departmentManager.service;

import com.familyfirstsoftware.departmentManager.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();


    public Department deleteDepartment(Department department);

    public Department fetchDepartmentById(Long id);

    public void deleteById(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
