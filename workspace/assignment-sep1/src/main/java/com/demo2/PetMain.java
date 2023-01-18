package com.demo2;

public class PetMain {

	public static void main(String[] args) {
		Pet pet1 = PetFactory.createPet("dog");
		Pet pet2 = PetFactory.createPet("cat");
		Pet pet3 = PetFactory.createPet("lion");
		Pet pet4 = PetFactory.createPet("fox");
		
		System.out.println(pet1.petDetails());
		System.out.println(pet2.petDetails());
		System.out.println(pet3.petDetails());
		System.out.println(pet4.petDetails());
		
		
	}

}
