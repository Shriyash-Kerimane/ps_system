package com.demo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableDemo {

	public static void main(String[] args) throws Exception {
final String JDBC_URL="jdbc:mariadb://localhost:3306/sapientdb";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(JDBC_URL, "root" ,"root");
		
		CallableStatement cst = conn.prepareCall("{call addBonus(?,?)}");
		
		cst.setInt(1, 102);
		cst.setInt(2, 6000);
		
		cst.execute();

	}

}
