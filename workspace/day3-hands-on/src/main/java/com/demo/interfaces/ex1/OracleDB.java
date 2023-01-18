package com.demo.interfaces.ex1;

public class OracleDB implements MyConnection{

	@Override
	public String getConnectionInfo() {
		return "Oracle is connected";
	}

	@Override
	public String getDetails() {
		return "Oracle 8.0.1";
	}

}
