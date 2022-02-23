package com.familyfirstsoftware.departmentManager.repositoryOrDAO;

import com.familyfirstsoftware.departmentManager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Must pass entity and Primary key type <Department, Long>
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // naming convention is very important here. it uses keywords
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
    public Department findByDepartmentName(String departmentName);

    // can pass native SQL query OR JPQL query by defalt
    //@Query("value = "", nativeQuery = true)
    public Department findByDepartmentNameIgnoreCase(String departmentName);

}
