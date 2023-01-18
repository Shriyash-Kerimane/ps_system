package com.demo2;

public class PetFactory{
    
    public static Pet createPet(String petType){
    	
    	switch(petType) {
    	case "cat":return new Cat();
    	case "dog":return new Dog();
    	case "fox":return new Fox();
    	case "lion":return new Lion();
    	default:throw new RuntimeException("Pet not found");
    	}
    }
}
