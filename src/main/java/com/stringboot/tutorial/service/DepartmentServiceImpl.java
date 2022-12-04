package com.stringboot.tutorial.service;

import com.stringboot.tutorial.entity.Department;
import com.stringboot.tutorial.repository.DepartmentRepository;
import error.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    // Repository is an extends of JpaRepository it provide us with functions similar to Laravel Eloquent
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department); // save function == Department::create()
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepository.findById(departmentId);

        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department Not available !!!");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(depDB.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(depDB.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(depDB.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }


    // Since there is no such method in Jpa Repository, we would need to create
    // a custom method for it in the DepartmentRepository
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
