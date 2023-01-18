package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchCust {

	public static void main(String[] args) throws Exception {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");

		PreparedStatement pst = conn
				.prepareStatement("insert into assignment(custId,custName, address, accountNo,balance) values (?,?,?,?,?)");

		// 1
		pst.setInt(1, 101);
		pst.setString(2, "beta");
		pst.setString(3, "Bangalore");
		pst.setInt(4, 123);
		pst.setDouble(5, 10000);
		pst.addBatch();

		// 2
		pst.setInt(1, 102);
		pst.setString(2, "gamma");
		pst.setString(3, "Pune");
		pst.setInt(4, 124);
		pst.setDouble(5, 20000);
		pst.addBatch();

		// 3
		pst.setInt(1, 103);
		pst.setString(2, "delta");
		pst.setString(3, "Sirsi");
		pst.setInt(4, 125);
		pst.setDouble(5, 30000);
		pst.addBatch();

		// 4
		pst.setInt(1, 104);
		pst.setString(2, "epsilon");
		pst.setString(3, "siddapur");
		pst.setInt(4, 126);
		pst.setDouble(5, 40000);
		pst.addBatch();
		
		// 5
		pst.setInt(1, 105);
		pst.setString(2, "zeta");
		pst.setString(3, "siddapur");
		pst.setInt(4, 127);
		pst.setDouble(5, 50000);	
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
