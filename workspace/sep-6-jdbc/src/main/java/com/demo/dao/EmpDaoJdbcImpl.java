package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.exceptions.EmpExitsException;
import com.demo.exceptions.EmpNotFoundException;
import com.demo.jdbc.Emp;

public class EmpDaoJdbcImpl implements EmpDao {

	@Override
	public Emp findById(Integer id) throws EmpNotFoundException {
		try {
			Connection conn = getConnection();
			PreparedStatement pst = conn.prepareStatement("select * from employee where empno=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Emp emp = new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
				return emp;
			} else {
				throw new EmpNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (EmpNotFoundException e) {
			throw e;
		}

	}

	@Override
	public String save(Emp e) throws EmpExitsException {

		try {

			Connection conn = getConnection();
			try {
				Emp e1 = findById(e.getEmpId());
				throw new EmpExitsException();
			} catch (EmpNotFoundException e1) {
				PreparedStatement pst = conn
						.prepareStatement("insert into employee(empno,name,address,salary) values (?,?,?,?)");

				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				pst.executeUpdate();
				return "Employee saved";
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2);
		} catch (EmpExitsException e2) {
			throw e2;
		}
	}

	@Override
	public String delete(Integer id) throws EmpNotFoundException {
		try {

			Connection conn = getConnection();
			try {
				Emp e1 = findById(id);
				PreparedStatement pst = conn.prepareStatement("delete from employee where empno = ?");
				pst.setInt(1, id);
				pst.executeUpdate();
				return "Employee removed";
			} catch (EmpNotFoundException e1) {
				throw new EmpNotFoundException();
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2);
		} catch (EmpNotFoundException e2) {
			throw e2;
		}
	}

	@Override
	public String update(Emp e) throws EmpNotFoundException {

		try {

			Connection conn = getConnection();
			try {
				Emp e1 = findById(e.getEmpId());
				PreparedStatement pst = conn
						.prepareStatement("insert into employee(empno,name,address,salary) values (?,?,?,?)");

				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				pst.executeUpdate();
				return "update successfull";
			} catch (EmpNotFoundException e1) {
				throw new EmpNotFoundException();
			}

		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new RuntimeException(e2);
		} catch (EmpNotFoundException e2) {
			throw e2;
		}
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> list = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement pst=conn.prepareStatement("select * from employee");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Emp employee = new Emp();
				employee.setEmpId(rs.getInt("EMPNO"));
				employee.setName(rs.getString("NAME"));
				employee.setCity(rs.getString("ADDRESS"));
				employee.setSalary(rs.getDouble("SALARY"));
				list.add(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Connection getConnection() throws SQLException {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL, "root", "root");
			return conn;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("Connection could not be created..");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
