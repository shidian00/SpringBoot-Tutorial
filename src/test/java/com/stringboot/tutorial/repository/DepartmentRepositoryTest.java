package com.stringboot.tutorial.repository;

import com.stringboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class DepartmentRepositoryTest {
//
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @BeforeEach
//    void setUp() {
//        Department department = new Department(1L,"ME","ME","ME-01");
//
//        System.out.print(department.getDepartmentName() + "<<<<<<<<<<<<<<<<<<<<<<<<<");
//        entityManager.persist(department);
//    }
//
//    @Test
//    public void whenFindById_thenReturnDepartment(){
//        Department department = departmentRepository.findById(1L).get();
//        assertSame(department.getDepartmentName(),"ME");
//
//    }
//}


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Mechanical Engineering")
                        .departmentCode("ME - 011")
                        .departmentAddress("Delhi")
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical Engineering");
    }
}