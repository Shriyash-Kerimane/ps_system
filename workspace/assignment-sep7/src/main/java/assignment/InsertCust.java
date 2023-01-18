package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertCust {

	public static void main(String[] args) throws Exception {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");

		PreparedStatement pst = conn
				.prepareStatement("insert into assignment(custId,custName, address, accountNo,balance) values (?,?,?,?,?)");

		pst.setInt(1, 100);
		pst.setString(2, "Alpha");
		pst.setString(3, "Bangalore");
		pst.setInt(4, 123);
		pst.setDouble(5, 10000);
		pst.executeUpdate();
}}
