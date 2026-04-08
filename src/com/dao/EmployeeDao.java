package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Employee;
import com.util.JDBCUtil;

public class EmployeeDao {
	//Dao-data access object-it contain only DB releated logic
	//we want DB connection
	
  Connection con=JDBCUtil.jdbcConnection();
  
  //create a method to insert data in DB table
  
  //Statement=> using that also we can insert record
  //we can not use query parameter
  //this is slow as compared to prepared statement
  
  //prepared statement => using that also we can insert record
  //we can use query parameter
  //this is fast as comapred to statement0
  
  public String saveEmployee(Employee employee) {
	  try {
	  PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?,?)");//query parameter
	  
	  pst.setInt(1, employee.getId());
	  pst.setString(2, employee.getName());
	  pst.setDouble(3, employee.getSalary());
	  pst.setString(4, employee.getGender());
	  pst.setString(5, employee.getDep());
	  
	  pst.execute();// to insert data
	  
	  
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return "Employee Register Sucessfully";
	  
  }
  
  //update Data
  public String updateEmployee(Employee employee) {
	  try {
	  PreparedStatement pst=con.prepareStatement("update employee set name=?,salary=?,dep=?,gender=? where id=?");
	  pst.setString(1, employee.getName());
	  pst.setDouble(2, employee.getSalary());
	  pst.setString(3, employee.getDep());
	  pst.setString(4, employee.getGender());
	  pst.setInt(5, employee.getId());
	  
	  pst.execute();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return "Employee update successfully";
  }
  
  //Get employee from DB by ID...
  
  public Employee getEmployeeById(int id) {
	  Employee employee=null;
	  try {
	  PreparedStatement pst=con.prepareStatement("Select * from employee where id=?");
	  pst.setInt(1, id);
	  
	 ResultSet rs =pst.executeQuery();
	 
	 while(rs.next()) {//to check data in database
		 int id1= rs.getInt("id");
		 String name= rs.getString("name");
		 double salary= rs.getDouble("salary");
		 String gender=rs.getString("gender");
		 String dep= rs.getString("dep");
		 
		  employee=new Employee(id1,name,salary,gender,dep);
		 
	 }
	 
	 
	  }catch (Exception e){
		  e.printStackTrace();
	  }
	  
	  return employee;
  }
  //to get all employes
  public  ArrayList<Employee> getAllEmployees() {
	  
	  ArrayList<Employee> employees=new ArrayList<Employee>();
	  
	  try {
	  PreparedStatement pst=con.prepareStatement("Select * from employee");
	  
	  ResultSet rs=pst.executeQuery();
	  
	  while(rs.next()) {
		  int id=rs.getInt("id");//("1")  you can give column no also
		  String name=rs.getString("name");//("2")
		  double salary=rs.getDouble("salary");
		  String gender=rs.getString("gender");
		  String dep=rs.getString("dep");
		  
		  Employee employee=new Employee(id,name,salary,gender,dep);
		  
		  employees.add(employee);
		  	 
	  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	  return employees;
  }
  
  public String deleteById(int id) {
	  try {
	  PreparedStatement pst=con.prepareStatement("delete from employee where id=?");
	  pst.setInt(1,id);
	  
	  //1--if employee deleted   0----if employee not deleted
	 int value= pst.executeUpdate();
	 
	 if(value>0) {
		 return "Employee deleted successfully";
	 }
	  
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	return null;
	  
	 
  }
 
}
