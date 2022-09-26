package com.springboot.crud_example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.crud_example.model.Employee;
import com.springboot.crud_example.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepository empRepository;
	
	public EmployeeService(EmployeeRepository empRepository)
	{
		this.empRepository=empRepository;
	}
	
	public List<Employee> showAllEmployees()
	{
		return empRepository.findAll();
	}
	
	public Employee showEmployeeById(Long employeeId)
	{
		//Employee emp=empRepository.findById(employeeId).get();
		Employee emp=empRepository.findById(employeeId).orElse(null);
		return emp;			
	}
	
	public Employee addEmployee(Employee emp)
	{
		return empRepository.save(emp);
	}
	
	public Employee editEmployee(Long employeeId,Employee empDetails)
	{
		
		Employee employee=empRepository.findById(employeeId).get();
		
		//Optional <Employee> employee=empRepository.findById(employeeId);
		//Employee emp1=(Employee) employee;
		
		employee.setEmail(empDetails.getEmail());
		employee.setFirstName(empDetails.getFirstName());
		employee.setLastName(empDetails.getLastName());
		
		final Employee updatedEmployee=empRepository.save(employee);
		return updatedEmployee;
	}
	
	public Map<String,Boolean> removeEmployee(Long employeeId)
	{
		
		Employee employee=empRepository.findById(employeeId).get();
		
		empRepository.delete(employee);
		
		Map <String,Boolean> response=new HashMap<>();
		
		response.put("Deleted", Boolean.TRUE);
		
		return response;
	}
}
