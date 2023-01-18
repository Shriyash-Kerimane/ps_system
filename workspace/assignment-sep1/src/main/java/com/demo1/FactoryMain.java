package com.demo1;

public class FactoryMain {

	public static void main(String[] args) {
		Job job = JobFactory.getJob("acc");
		Job job1 = JobFactory.getJob("sal");
		Job job2 = JobFactory.getJob("ope");
		Job job3 = JobFactory.getJob("dev");
		
		
		System.out.println(job.getJobDescription());
		System.out.println(job2.getJobDescription());
		System.out.println(job3.getJobDescription());
		System.out.println(job1.getJobDescription());
	}

}
