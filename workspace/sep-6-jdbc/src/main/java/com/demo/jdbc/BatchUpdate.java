package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate {

	public static void main(String[] args) throws Exception {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");

		PreparedStatement pst = conn
				.prepareStatement("insert into employee(empno,name,address,salary) values (?,?,?,?)");

		// 1
		pst.setInt(1, 105);
		pst.setString(2, "Zeta");
		pst.setString(3, "Delhi");
		pst.setDouble(4, 10000);
		pst.addBatch();

		// 2
		pst.setInt(1, 106);
		pst.setString(2, "eta");
		pst.setString(3, "Pune");
		pst.setDouble(4, 20000);
		pst.addBatch();

		// 3
		pst.setInt(1, 107);
		pst.setString(2, "theta");
		pst.setString(3, "Sirsi");
		pst.setDouble(4, 30000);
		pst.addBatch();

		// 4
		pst.setInt(1, 108);
		pst.setString(2, "iota");
		pst.setString(3, "siddapur");
		pst.setDouble(4, 40000);
		pst.addBatch();

		try {
			conn.setAutoCommit(false);
			int[] row = pst.executeBatch();
			conn.commit();
			System.out.println("Commited : Rows Inserted = " + row.length);
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("Roll back");
			e.printStackTrace();
		}finally {
			conn.setAutoCommit(true);
			conn.close();
		}
	}
}
