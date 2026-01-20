package com.wip.dao;

import com.wip.model.Employee;

public interface EmployeeDao {
	public void createEmployee(Employee emp);
	public void showEmployee();
	public void updateEmployee();
	public void deleteEmployee();
	public void insertEmployeeViaProc(Employee emp);
	public void getDBinfo();
}
