package com.demo.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // add a method to sort by first name
    // Spring Data JPA parses the method name and looks for
    // a specific pattern, creates an appropriate query all by itself.
    // behind the scenes: "from Employees order by firstName asc"
    public List<Employee> findAllByOrderByFirstNameAsc();
}
