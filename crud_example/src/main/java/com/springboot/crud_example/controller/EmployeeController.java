package com.springboot.crud_example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud_example.model.Employee;
import com.springboot.crud_example.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController 
{
	@Autowired
	private EmployeeService empService;
	/*
	 * @Autowired private EmployeeRepository empRepository;
	 */
	
	public EmployeeController(EmployeeService empService)
	{
		this.empService=empService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		//return empRepository.findAll();
		
		return empService.showAllEmployees();
	}

	//public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long employeeId){
		
		//Optional<Employee> emp=empRepository.findById(employeeId);
	@GetMapping("/employees/{id}")
	public ResponseEntity <Employee> getEmployeeById(@PathVariable(value="id") Long employeeId)
	{
		//Employee emp=empRepository.findById(employeeId).get();
		//Employee emp=empRepository.findById(employeeId).orElse(null);
		//return ResponseEntity.ok(emp);
		
		//Employee emp=empService.showEmployeeById(employeeId);
		return ResponseEntity.ok(empService.showEmployeeById(employeeId));
	}
	
	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		//return empRepository.save(employee);
		return empService.addEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity <Employee> updateEmployee(@PathVariable(value="id") Long employeeId,
			@Valid @RequestBody Employee empDetails)
	{
		
		//Employee employee=;
		
		//Optional <Employee> employee=empRepository.findById(employeeId);
		//Employee emp1=(Employee) employee;
		
		/*
		 * employee.setEmail(empDetails.getEmail());
		 * employee.setFirstName(empDetails.getFirstName());
		 * employee.setLastName(empDetails.getLastName());
		 * 
		 * final Employee updatedEmployee=empRepository.save(employee);
		 */
		return ResponseEntity.ok(empService.editEmployee(employeeId, empDetails));
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="id")Long employeeId)
	{
		//Employee employee=empRepository.findById(employeeId).get();
		
		//Map <String,Boolean> response=new HashMap<>();
		
		//response.put("Deleted", Boolean.TRUE);
		
		return empService.removeEmployee(employeeId);
	}
}
