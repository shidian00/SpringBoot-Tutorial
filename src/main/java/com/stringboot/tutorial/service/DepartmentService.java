package com.stringboot.tutorial.service;

import com.stringboot.tutorial.entity.Department;
import error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
