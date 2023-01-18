package com.demo1;

public abstract class Job {

	public abstract String getJobDescription();
}

class Developer extends Job{

	@Override
	public String getJobDescription() {
		
		return "Developer mainly responsible for developing, coding, installing, and maintaining software systems";
	}
	
}

class Accountant extends Job{

	@Override
	public String getJobDescription() {
		
		return "Accountant mainly helps businesses make critical financial decisions by collecting, tracking, and correcting the company's finances";
	}
	
}

class Sales extends Job{

	@Override
	public String getJobDescription() {
		
		return "Sales mainly identifying and educating prospective customers while supporting existing clients with information and assistance that relates to products and services.";
	}
	
}

class Operations extends Job{

	@Override
	public String getJobDescription() {
		
		return "Operations mainly formulating strategy, improving performance, procuring material and resources and securing compliance";
	}
	
}