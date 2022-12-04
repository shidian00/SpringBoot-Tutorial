package com.stringboot.tutorial.controller;

import com.stringboot.tutorial.entity.Department;
import com.stringboot.tutorial.service.DepartmentService;
import com.stringboot.tutorial.service.DepartmentServiceImpl;
import error.DepartmentNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    // Tells the application context to inject an instance of departmentService here
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
    // DepartmentService service = new DepartmentServiceImpl(); //Manual way of doing
        LOGGER.info("New department have been created. ");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Department list have been fetched. ");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable(name = "id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable(name="id") Long departmentId){

        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully.";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable(name = "id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);

    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable(name = "name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
