package com.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.controller.EmployeeController;
import com.entity.Employee;
import com.exception.EmployeeNotFoundException;
import com.exception.EmployeeWithThisGenderNotFound;

public class EmployeeMain {
	public static void main(String args []) {
		EmployeeController controller=new EmployeeController();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("1.Save Employee");
			System.out.println("2.Update Employee");
			System.out.println("3.Get EmployeeById");
			System.out.println("4.Get All Employees");
			System.out.println("5.Delete By Id");
			System.out.println("6.Get All Male Employees");
			System.out.println("7.Get All Female Employees");
			System.out.println("8.Get All Employees Name Star With R");
			System.out.println("9.Exit");
			
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			
			if(choice==1) {
				System.out.println("Enter ID");
				int id=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Name");
				String name=sc.nextLine();
				
				System.out.println("Enter Salary");
				double salary=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter Gender");
				String gender=sc.nextLine();
				
				System.out.println("Enter Department");
				String dep=sc.nextLine();
				
				Employee e=new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setGender(gender);
				e.setDep(dep);
				
				String msg=controller.saveEmployee(e);
				System.out.println(msg);
				
				
				
			}else if(choice==2) {
				System.out.println("Enter ID");
				int id=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Name");
				String name=sc.nextLine();
				
				System.out.println("Enter Salary");
				double salary=sc.nextDouble();
				sc.nextLine();
				
				System.out.println("Enter Gender");
				String gender=sc.nextLine();
				
				System.out.println("Enter Department");
				String dep=sc.nextLine();
				
				Employee e= new Employee();
				
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setGender(gender);
				e.setDep(dep);
				
				String msg=controller.updateEmployee(e);
				System.out.println(msg);
				
			}else if(choice==3) {
				System.out.println("Enter ID To Get Employee");
				int id=sc.nextInt();
				
				try {
				
				Employee employee=controller.getEmployeeById(id);
				System.out.println("ID         :"+employee.getId());
				System.out.println("Name       :"+employee.getName());
				System.out.println("Salary     :"+employee.getSalary());
				System.out.println("Gender     :"+employee.getGender());
				System.out.println("Department :"+employee.getDep());	
				}catch(EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
			}else if(choice==4) {
				
				 ArrayList<Employee> employees=controller.getAll();
				 
				 for( Employee employee :employees) {
						System.out.println("ID         :"+employee.getId());
						System.out.println("Name       :"+employee.getName());
						System.out.println("Salary     :"+employee.getSalary());
						System.out.println("Gender     :"+employee.getGender());
						System.out.println("Department :"+employee.getDep());
						System.out.println("=================================================");
					 
				 }
				 
				
			}else if(choice==5) {
				System.out.println("Enter Id To Delete Employee");
				int id=sc.nextInt();
				try {
				String msg=controller.deleteById(id);
				System.out.println(msg);
				}catch(EmployeeNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
			}else if(choice==6) {
				ArrayList<Employee> emp=controller.getAllMaleEmployees();
				       
				      for(Employee e:emp) {
				    	  System.out.println(e.getId());
				    	  System.out.println(e.getName());
				    	  System.out.println(e.getSalary());
				    	  System.out.println(e.getGender());
				    	  System.out.println(e.getDep());
				    	  System.out.println("===========================");
				      }
			}else if(choice==7) {
				try {
				ArrayList<Employee> emp=controller.getAllFemaleEmployees();
			       
			      for(Employee e:emp) {
			    	  System.out.println(e.getId());
			    	  System.out.println(e.getName());
			    	  System.out.println(e.getSalary());
			    	  System.out.println(e.getGender());
			    	  System.out.println(e.getDep());
			    	  System.out.println("====================================");
			      }
				}catch(EmployeeWithThisGenderNotFound e) {
					System.out.println(e.getMessage());
				}
				
			}else if(choice==8) {
				ArrayList<Employee> emp=controller.getAllMaleEmployeesStartsWithR();
				
				for(Employee e:emp) {
					  System.out.println(e.getId());
			    	  System.out.println(e.getName());
			    	  System.out.println(e.getSalary());
			    	  System.out.println(e.getGender());
			    	  System.out.println(e.getDep());
			    	  System.out.println("====================================");
				}
			}
			
			
			
			else if(choice==9) {
				System.out.println("Thank You");
				break;
			}else {
				System.out.println("Invalid Choice");
			}
			
			
		}
		
		/*Employee e=new Employee();
		e.setId(1);
		e.setName("Sham");
		e.setDep("Finance");
		e.setGender("Male");
		e.setSalary(100000);*/
		
		//String msg=controller.saveEmployee(e);
		//System.out.println(msg);
		
		//String msg=controller.updateEmployee(e);
		//System.out.println(msg);
	}

}
