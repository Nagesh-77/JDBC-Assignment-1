package com.controller;

import java.util.ArrayList;

import com.entity.Employee;
import com.service.EmployeeService;

public class EmployeeController {

	EmployeeService service= new EmployeeService();
	
	public String saveEmployee(Employee employee) {
		
		String msg=service.saveEmployee(employee);
		
		return msg;
	}
	
	public String updateEmployee(Employee employee) {
		String msg=service.updateEmployee(employee);
		return msg;
}
	
	public Employee getEmployeeById(int id) {
		Employee employee=service.getEmployeeById(id);
		return employee;
	}
	
	public  ArrayList<Employee> getAll() {
		 ArrayList<Employee> employees=service.getAllEmployees();
		 return employees;
	}
	
	
	public ArrayList<Employee> getAllMaleEmployees() {
		ArrayList<Employee> maleEmployees=service.getAllMaleEmployees();
		return maleEmployees;
	}
	
	public ArrayList<Employee> getAllFemaleEmployees() {
		ArrayList<Employee> femaleEmployees=service.getAllFemaleEmployees();
		return femaleEmployees;
	}
	
	public ArrayList<Employee> getAllMaleEmployeesStartsWithR(){
		ArrayList<Employee> emp= service.getAllMaleEmployeesStartsWithR();
		return emp;
	}
	
	
	
	public String deleteById(int id) {
		return service.deleteById( id);
	}
}
