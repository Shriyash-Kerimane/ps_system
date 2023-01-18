package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class ListCust {

	public static void main(String[] args) throws Exception {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/sapientdb";

		Class.forName("org.mariadb.jdbc.Driver");

		Connection conn = DriverManager.getConnection(JDBC_URL, "root", "root");
		
		List<Cust> list = new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("select * from assignment");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				Cust customer = new Cust();
				customer.setCustId(rs.getInt("CUSTID"));
				customer.setCustName(rs.getString("CUSTNAME"));
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setAccountNo(rs.getInt("ACCOUNTNO"));
				customer.setBalance(rs.getDouble("BALANCE"));
				list.add(customer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Cust person : list) {
			System.out.println("( "+person.getCustId()+" "+person.getCustName()+" "+person.getAddress()+" "+person.getAccountNo()+" "+person.getBalance()+ " )");
		}
	}

}
