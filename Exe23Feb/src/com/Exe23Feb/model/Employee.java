package com.Exe23Feb.model;

//import java.util.Comparator;

public class Employee implements Comparable<Employee>
{
	String Name;
	String Department;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public Employee(String name, String department) {
		super();
		Name = name;
		Department = department;
	}
	
	@Override
    public int compareTo(Employee other) {
        // your implementation
		return (this.Name).compareTo(other.Name);
    }
	
	
}
