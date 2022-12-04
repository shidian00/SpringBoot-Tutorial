package com.stringboot.tutorial.repository;

import com.stringboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

//     Department findByDepartmentName(String departmentName);

    // This is called as Jpa Query Creation, you can even self define SQL query by adding @Query() here
     Department findByDepartmentNameIgnoreCase(String departmentName);
}
