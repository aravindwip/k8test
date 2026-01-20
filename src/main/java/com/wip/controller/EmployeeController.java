package com.wip.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.wip.dao.EmployeeDao;
import com.wip.dao.EmployeeDaoImpl;
import com.wip.model.Employee;
import com.wip.model.NameComparator;
import com.wip.model.Salary;

public class EmployeeController implements EmployeeInterface {

	Employee emp;// Class Instanitaion
	Salary sal;
	Scanner scanner = new Scanner(System.in);
	List<Employee> empList = new ArrayList<>();
	EmployeeDao dao = new EmployeeDaoImpl();
	public void addEmployee() {
		emp = new Employee();
		System.out.println("Enter Emp ID");
		int eid = scanner.nextInt();
		emp.setEmpId(eid);
		System.out.println("Enter Emp Name");
		String ename = scanner.next();
		emp.setEmpName(ename);
		sal = new Salary();
		System.out.println("Enter Salary Details:");

		System.out.println("Enter Basic Salary");
		int basic = scanner.nextInt();

		sal.setBasic(basic);
		sal.setHra();
		sal.setPf();
		sal.setGross();
		sal.setNet();

		emp.setSalary(sal);
		empList.add(emp);
		dao.createEmployee(emp);
		System.out.println("Employee Added Successfully");

	}

	public void viewEmployee() {
		// System.out.println(emp.getEmpId() + " " + emp.getEmpName());
		// System.out.println(emp);
		//System.out.println(empList);
		Iterator it = empList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("****************************");
		dao.showEmployee();
	}

	public void addEmployeeToArray() {

	}

	@Override
	public void sortByEmpId() {
		System.out.println("Sorting by Emp ID using Comparable");
		Collections.sort(empList);
		Iterator it = empList.iterator();
		while (it.hasNext()) {

			System.out.println(it.next());
		}
	}

	@Override
	public void sortByEname() {
		System.out.println("Sorting by Emp Name using Comparator");
		Collections.sort(empList, new NameComparator());
		Iterator it = empList.iterator();
		while (it.hasNext()) {

			System.out.println(it.next());
		}
		
	}

	@Override
	public void sortByEidUsingComparator() {
		
		System.out.println("Sorting by Emp Name using Comparator");
		Collections.sort(empList, new Employee().idComparator);
		Iterator it = empList.iterator();
		while (it.hasNext()) {

			System.out.println(it.next());
		}
	}

	@Override
	public void serializeEmp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deserializeEmp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee() {
		
		dao.updateEmployee();
		
	}

	@Override
	public void deleteEmployee() {
		dao.deleteEmployee();
		
	}

	@Override
	public void insertEmployeeViaProc() {
		emp = new Employee();
		System.out.println("Enter Emp ID");
		int eid = scanner.nextInt();
		emp.setEmpId(eid);
		System.out.println("Enter Emp Name");
		String ename = scanner.next();
		emp.setEmpName(ename);
		sal = new Salary();
		System.out.println("Enter Salary Details:");

		System.out.println("Enter Basic Salary");
		int basic = scanner.nextInt();

		sal.setBasic(basic);
		sal.setHra();
		sal.setPf();
		sal.setGross();
		sal.setNet();

		emp.setSalary(sal);
		dao.insertEmployeeViaProc(emp);
		
	}

	@Override
	public void getDBinfo() {
		dao.getDBinfo();
		
	}
	
}
