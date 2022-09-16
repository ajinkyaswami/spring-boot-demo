package com.springboot.crud_example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud_example.model.Employee;
import com.springboot.crud_example.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController 
{
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empRepository.findAll();
	}

	@GetMapping("/employees/{id}")
	//public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long employeeId){
		
		//Optional<Employee> emp=empRepository.findById(employeeId);
	
	public ResponseEntity <Employee> getEmployeeById(@PathVariable(value="id") Long employeeId)
	{
			
		//Employee emp=empRepository.findById(employeeId).get();
		Employee emp=empRepository.findById(employeeId).orElse(null);
		return ResponseEntity.ok(emp);			
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		return empRepository.save(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity <Employee> updateEmployee(@PathVariable(value="id") Long employeeId,
			@Valid @RequestBody Employee empDetails)
	{
		
		Employee employee=empRepository.findById(employeeId).get();
		
		//Optional <Employee> employee=empRepository.findById(employeeId);
		//Employee emp1=(Employee) employee;
		
		employee.setEmail(empDetails.getEmail());
		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());
		
		final Employee updatedEmployee=empRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="id")Long employeeId)
	{
		
		Employee employee=empRepository.findById(employeeId).get();
		
		empRepository.delete(employee);
		
		Map <String,Boolean> response=new HashMap<>();
		
		response.put("Deleted", Boolean.TRUE);
		
		return response;
	}
}
