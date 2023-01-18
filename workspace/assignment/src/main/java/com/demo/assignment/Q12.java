package com.demo.assignment;

public class Q12 {
	public String getCityByCode(int n) {
		switch (n) {
		case 1: 
			return "Delhi";
		case 2:
			return "Noida";
		case 3:
			return "Gurugram";
		case 4:
			return "Bangalore";
		default:
			return "Invalid code";		
	}

}
}
