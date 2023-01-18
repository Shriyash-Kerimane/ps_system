package com.demo.template.ex1;

public abstract class Game {
	
	public abstract void initGame();
	
	public abstract void start();
	 
	public abstract void end();
	
	public void play() {
		initGame();
		start();
		end();
	}

}

class Mario extends Game{

	@Override
	public void initGame() {
		System.out.println("Mario is Loading...");
		
	}

	@Override
	public void start() {
		System.out.println("Mario is Started...");
		
	}

	@Override
	public void end() {
		System.out.println("Mario is Ended...");
		
	}
}	
class PubG extends Game{

	@Override
	public void initGame() {
		System.out.println("Pubg is Loading...");
		
	}

	@Override
	public void start() {
		System.out.println("Pubg is Started...");
		
	}

	@Override
	public void end() {
		System.out.println("Pubg is Ended...");
		
	}
	
}
	
	

