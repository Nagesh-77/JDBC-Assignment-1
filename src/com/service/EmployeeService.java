package com.service;

import java.util.ArrayList;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.exception.EmployeeNotFoundException;
import com.exception.EmployeeWithThisGenderNotFound;
//we need to write logic in service calss
public class EmployeeService {
 EmployeeDao dao=new EmployeeDao();
 
 public String saveEmployee(Employee employee) {
	 
	String msg= dao.saveEmployee(employee);
	
	return msg;
 }
 
 public String updateEmployee(Employee employee) {
	 
	 String msg=dao.updateEmployee(employee);
	 
	 return msg;
	 	 
 }
 
 public Employee getEmployeeById(int id) {
	Employee employee= dao.getEmployeeById(id);
	if(employee==null) {
		throw new EmployeeNotFoundException("Employee not found with id : "+id);
	}
	return employee;
 }
 
 
 public  ArrayList<Employee> getAllEmployees() {
	 ArrayList<Employee> employees= dao.getAllEmployees();
	 return employees;
	 
	 //return dao.getAllEmployees();
	 
 }
 
 public  ArrayList<Employee> getAllMaleEmployees() {
	 ArrayList<Employee> employees= dao.getAllEmployees();
	 
	 ArrayList<Employee> maleEmployee= new ArrayList<Employee>();
	 
	 for(Employee e:employees) {
		 
		 if(e.getGender().equals("Male")) {
			 
			 maleEmployee.add(e);
			 
		 }
	 }
	 if(maleEmployee.isEmpty()) {
		 throw new EmployeeWithThisGenderNotFound("No male Employee Exist");
	 }
	 
	  return maleEmployee;
	 
 }
 
 public  ArrayList<Employee> getAllFemaleEmployees() {
	 ArrayList<Employee> employees= dao.getAllEmployees();
	 
	 ArrayList<Employee> femaleEmployee= new ArrayList<Employee>();
	 
	 for(Employee e:employees) {
		 
		 if(e.getGender().equals("Female")) {
			 
			 femaleEmployee.add(e);
			 
		 }
	 }
	 if(femaleEmployee.isEmpty()) {
		 throw new EmployeeWithThisGenderNotFound("No Female Employee Exist");
	 }
	 
	  return femaleEmployee;
	 
 }
 
 public  ArrayList<Employee> getAllMaleEmployeesStartsWithR() {
	 ArrayList<Employee> employees= dao.getAllEmployees();
	 ArrayList<Employee> emp=new ArrayList<Employee>();
	 for(Employee e:employees) {
		 if(e.getName().startsWith("R")) {
			 emp.add(e);
		 }
	 }
	 return emp;
	 
 }
 
 
 
 public String deleteById(int id) {
	 String msg=dao.deleteById(id);    	 //or  return dao.deleteById(id);
	 
	 if(msg==null) {
		 throw new EmployeeNotFoundException("Employee not found with id : "+id);
	 }
	 
	 return msg;
	 
	 
	 
	 
 }
 
 
 
 
}
