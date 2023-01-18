package com.demo.interfaces.ex1;

public class DBMain {

	public static void main(String[] args) {
		MyConnection db=new OracleDB();
		
		System.out.println(db.getConnectionInfo());
		System.out.println(db.getDetails());
		System.out.println(db.getresultData());

	}

}
