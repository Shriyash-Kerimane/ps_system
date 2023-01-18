package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo2 {

	public static void main(String[] args) throws Exception{
		
		final String JDBC_URL="jdbc:mariadb://localhost:3306/sapientdb";
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(JDBC_URL, "root" ,"root");
		
		PreparedStatement pst=conn.prepareStatement("select * from employee where empno=?");
	//	for(int i = 100; i<105;i++) {
		pst.setInt(1, 100);
		ResultSet rs = pst.executeQuery();
		
///		for ? and set check this
//		select * from employee where salary between ? and ?
//		pst.setInt(1, 30000);
//		pst.setInt(2, 70000);
		
		while(rs.next()){
			int id = rs.getInt("EMPNO");
			String name=rs.getString("NAME");
			String city = rs.getString("ADDRESS");
			double salary = rs.getDouble("SALARY");
			System.out.println(id+" "+name+" "+city+" "+salary);
		}
		}
	//}

}
