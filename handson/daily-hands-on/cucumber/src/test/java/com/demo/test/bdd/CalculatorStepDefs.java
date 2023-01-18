package com.demo.test.bdd;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepDefs {
	Calculator cal;
	@Given("create the object of Calculator")
	public void create_the_object_of_calculator() {
	    cal = new Calculator();
	}

	@When("I pass {int} and {int}")
	public void i_pass_and(Integer int1, Integer int2) {
	    System.out.println("paramas pased...");
	}

	@Then("add method should return {int}")
	public void add_method_should_return(Integer int1) {
	    Assertions.assertEquals(7, int1);
	}
	
	@Given("with the object of Calculator")
	public void with_the_object_of_calculator() {
	    System.out.println();
	}

	@Then("subtract method should return {int}")
	public void subtract_method_should_return(Integer int1) {
	    Assertions.assertEquals(4, int1);

	}
}
