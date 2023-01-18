package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteCust {

	public static void main(String[] args) throws Exception {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");

		PreparedStatement pst = conn.prepareStatement("delete from assignment where custId = ?");
		pst.setInt(1, 104);
		
		pst.executeUpdate();

	}

	}


