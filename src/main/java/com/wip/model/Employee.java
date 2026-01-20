package com.wip.model;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	
	private int empId;
	private String empName;
	private Salary salary;     // HAS-A Relationship
	
	public Employee(){
		System.out.println("Employee Object Created");
	}
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	
	
	
	public Employee(int empId, String empName, Salary salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee e) {
		
		return this.empId - e.empId;
	}
	// Comparator as Anonymous Inner Class
	public Comparator<Employee> idComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			
			return e1.getEmpId() - e2.getEmpId();
		}
		
	};
	
	
}
