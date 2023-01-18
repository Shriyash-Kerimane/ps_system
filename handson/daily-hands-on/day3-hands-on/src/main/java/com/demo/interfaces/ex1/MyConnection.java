package com.demo.interfaces.ex1;

public interface MyConnection {
	String releaseVersion="11.0.12";
	String getConnectionInfo();
	String getDetails();
	
	default String[] getresultData() {
		throw new IllegalArgumentException("Not implemented..");
	}

}
