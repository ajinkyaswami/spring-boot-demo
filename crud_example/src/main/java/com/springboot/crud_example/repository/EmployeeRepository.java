package com.springboot.crud_example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.crud_example.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	/*
	 * @Query("SELECT id FROM employees emp WHERE (:firstName is null or employees.firstName = :firstName) "
	 * + "and (:lastName is null or employees.lastName = :lastName) " +
	 * "and (:email is null or employees.email = :email) ") List<Employee>
	 * filterEmployeesByParameters(
	 * 
	 * @Param("id")Long id,
	 * 
	 * @Param("firstName")String firstName,
	 * 
	 * @Param("lastName")String lastName,
	 * 
	 * @Param("email")String email );
	 */
}
