package com.springboot.crud_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud_example.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
