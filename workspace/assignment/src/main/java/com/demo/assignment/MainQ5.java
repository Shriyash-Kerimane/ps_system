package com.demo.assignment;

public class MainQ5 {

	public static void main(String[] args) {
		PersonalLoan p=new PersonalLoan(10.0, 10000, 10, "Nikola");
		System.out.println(p.showDetails());
		p.setMonths(10);
		System.out.println(p.showDetails());
		
		
		HomeLoan h=new HomeLoan	(10.0, 10000, 5, "Tesla");
		System.out.println(h.showDetails());

	}

}
