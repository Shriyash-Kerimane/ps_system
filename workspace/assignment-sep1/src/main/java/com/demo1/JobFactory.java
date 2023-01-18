package com.demo1;

public class JobFactory {
	
	public static Job getJob(String Desc) {
		if(Desc.equals("acc")) {
			return new Accountant();
		}else if(Desc.equals("sal")) {
			return new Sales();
		}else if(Desc.equals("dev")) {
			return new Developer();
		}else if(Desc.equals("ope")) {
			return new Operations();
		}else {
			throw new RuntimeException("Job not found which you are looking for...");
		}
	}

}
