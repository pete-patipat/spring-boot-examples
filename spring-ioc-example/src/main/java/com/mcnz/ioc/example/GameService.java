package com.mcnz.ioc.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameService {

	//Score score = new Score();
	private Score score; // Make score private for encapsulation

	public GameService() {
		// Initialize the Spring ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		// Retrieve the 'score' bean from the context
		this.score = context.getBean("thescore", Score.class);
	}

	public void playTheGame(String clientGesture) {
		// Use the methods on the Score object for better encapsulation
		if (clientGesture.equalsIgnoreCase("scissors")) { score.increaseLosses();}
		else if (clientGesture.equalsIgnoreCase("paper")) { score.increaseWins();}
		else if (clientGesture.equalsIgnoreCase("rock")) { score.increaseTies();}
		// Consider adding a default case or error handling for invalid gestures
	}


	public static void main (String args[]) {
		GameService gs = new GameService();
		gs.playTheGame("scissors"); // Loss
		gs.playTheGame("paper");    // Win
		gs.playTheGame("scissors"); // Loss
		gs.playTheGame("rock");     // Tie

		// Use the toString() method for a cleaner output
		System.out.println("Final Score: " + gs.score.toString());
	}
}
