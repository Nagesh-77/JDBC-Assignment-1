package com.entity;

public class Employee {
private int id;
private String name;
private double salary;
private String dep;
private String gender;


public Employee(int id, String name, double salary, String gender, String dep) {
	this.id = id;
	this.name = name;
	this.salary = salary;
	this.dep = dep;
	this.gender = gender;
}
public Employee() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDep() {
	return dep;
}
public void setDep(String dep) {
	this.dep = dep;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}


}
