package com.wip.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wip.model.Employee;
import com.wip.util.MyDbConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;

	public void createEmployee(Employee emp) {

		try {
			con = MyDbConnection.getMyConnection();
			con.setAutoCommit(false);
			psmt = con.prepareStatement("insert into employees(eid,ename,basic,hra,pf,gross,net) values(?,?,?,?,?,?,?)");
			psmt.setInt(1, emp.getEmpId());
			psmt.setString(2, emp.getEmpName());
			psmt.setInt(3, emp.getSalary().getBasic());
			psmt.setDouble(4, emp.getSalary().getHra());
			psmt.setDouble(5, emp.getSalary().getPf());
			psmt.setDouble(6, emp.getSalary().getGross());
			psmt.setDouble(7, emp.getSalary().getNet());
			int noofrows = psmt.executeUpdate();
			System.out.println(noofrows + " Row(s) Inserted");
			con.commit();
		} catch (SQLException e) {

			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	public void showEmployee() {
		con = MyDbConnection.getMyConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employees");
			while (rs.next()) {
				System.out.println("EID: " + rs.getInt("eid"));
				System.out.println("ENAME: " + rs.getString("ename"));
				System.out.println("BASIC: " + rs.getInt("basic"));
				System.out.println("HRA: " + rs.getDouble("hra"));
				System.out.println("PF: " + rs.getDouble("pf"));
				System.out.println("GROSS: " + rs.getDouble("gross"));
				System.out.println("NET: " + rs.getDouble("net"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void updateEmployee() {
		con = MyDbConnection.getMyConnection();

	}

	public void deleteEmployee() {
		con = MyDbConnection.getMyConnection();
	}

	@Override
	public void insertEmployeeViaProc(Employee emp) {
		con = MyDbConnection.getMyConnection();
		try {
			CallableStatement cs = con.prepareCall("call insertEmp(?,?,?,?,?,?,?)");
			cs.setInt(1, emp.getEmpId());
			cs.setString(2, emp.getEmpName());
			cs.setInt(3, emp.getSalary().getBasic());
			cs.setDouble(4, emp.getSalary().getHra());
			cs.setDouble(5, emp.getSalary().getPf());
			cs.setDouble(6, emp.getSalary().getGross());
			cs.setDouble(7, emp.getSalary().getNet());
			cs.execute();
			System.out.println("Employee inserted Successfully via Procedure");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void getDBinfo() {
		con = MyDbConnection.getMyConnection();
		try {
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println("DB product name " + dbmd.getDatabaseProductName());
			System.out.println("DB product  version" + dbmd.getDatabaseMajorVersion()+"."+dbmd.getDatabaseMinorVersion());
			System.out.println("DB Driver name " + dbmd.getDriverName());
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}

/**

DELIMITER //
create procedure insertEmp(
  IN peid int,  IN pename varchar(30),  IN basic int,
  IN hra decimal(10,2),  IN pf decimal(10,2), IN gross decimal(10,2),
  IN net decimal(10,2)
)
begin
    insert into employees(eid,ename,basic,hra,pf,gross,net) values(peid,pename,basic,hra,pf,gross,net);
end //
DELIMITER ;

call insertEmp(3,"Hari",5000,500.00,250.00,5750.00,5500.00);

*/