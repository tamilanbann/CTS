package com.Ece23Feb.app;

import java.util.TreeSet;

import com.Exe23Feb.model.Employee;
import java.util.*;

public class Application {

	public static void main(String[] args) 
	{
		Collection <Employee> employeeList=new TreeSet<Employee>();
		
		Scanner input= new Scanner(System.in);
		System.out.println("Enter number of Employee details to be added:");
		int n=input.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Employee "+(i+1)+" Name:");
			String name=input.next();
			System.out.println("Enter Employee "+(i+1)+" Department:");
			String department=input.next();
			Employee E=new Employee(name,department);
			//System.out.println(E.getName());
			employeeList.add(E);
		}
		//Collections.sort(employeeList);
		System.out.println("ordered Employee list");
		System.out.printf("\n%20s  %15s","Name","Department");
		for(Employee X:employeeList)
		{
			System.out.printf("\n%20s  %15s",X.getName(),X.getDepartment());
			//test repo
		}

	}

}
