package com.familyfirstsoftware.departmentManager.service;

import com.familyfirstsoftware.departmentManager.entity.Department;
import com.familyfirstsoftware.departmentManager.error.DepartmentNotFoundException;
import com.familyfirstsoftware.departmentManager.repositoryOrDAO.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department deleteDepartment(Department department) {
        departmentRepository.delete(department);
        return department;
    }

    // without the .get() it returns an optional.
    @Override
    public Department fetchDepartmentById(Long id) {

        // custom error handling for if the ID is not found
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            try {
                throw new DepartmentNotFoundException("Department Not Found");
            } catch (DepartmentNotFoundException e) {
                e.printStackTrace();
            }
        }
        return department.get();
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department departmentFromPutRequest) {
        Department departmentToSave = departmentRepository.findById(id).get();

        // check if name is not null && not blank then sets it
        // and updates the database
        if(Objects.nonNull(departmentFromPutRequest.getDepartmentName()) &&
                !"".equalsIgnoreCase(departmentFromPutRequest.getDepartmentName())){
            departmentToSave.setDepartmentName(departmentFromPutRequest.getDepartmentName());
        }
        if(Objects.nonNull(departmentFromPutRequest.getDepartmentCode()) &&
                !"".equalsIgnoreCase(departmentFromPutRequest.getDepartmentCode())){
            departmentToSave.setDepartmentCode(departmentFromPutRequest.getDepartmentName());
        }
        if(Objects.nonNull(departmentFromPutRequest.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(departmentFromPutRequest.getDepartmentAddress())){
            departmentToSave.setDepartmentAddress(departmentFromPutRequest.getDepartmentAddress());
        }
        return departmentRepository.save(departmentToSave);
    }

    // no default on in our JPA repository so be must define our own.
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}



