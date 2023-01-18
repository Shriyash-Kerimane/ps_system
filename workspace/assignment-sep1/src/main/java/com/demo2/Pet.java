package com.demo2;

abstract class Pet {
	public abstract String petDetails();
}

class Cat extends Pet{
	@Override
	public String petDetails() {
		return "Cat is usually kept as a companion indoor";
	}
}

class Dog extends Pet{
	@Override
	public String petDetails() {
		return "Dogs are a great companion for humans as they are loyal and friendly";
	}
}

class Fox extends Pet{
	@Override
	public String petDetails() {
		return "Fox are usually not domesticated as their cunning and cruel nature";
	}
}

class Lion extends Pet{
	@Override
	public String petDetails() {
		return "Lions as pet can be seen in some of gulf countries as a symbol of pride";
	}
}

