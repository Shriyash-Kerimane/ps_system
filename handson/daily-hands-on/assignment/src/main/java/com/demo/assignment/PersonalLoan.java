package com.demo.assignment;

public class PersonalLoan {
	private double percentage;
	private long loanAmount;
	private int months;
	private String person;
	
	public PersonalLoan(double percentage,long loanAmount,int months,String person)
	{
		this.percentage=percentage;
		this.loanAmount=loanAmount;
		this.months=months;
		this.person=person;
	}
	
	public String showDetails() {
		return percentage+" "+loanAmount+" "+months+" "+person;
	}
	
	public void setMonths(int months) {
		this.months=months;
	}

}
