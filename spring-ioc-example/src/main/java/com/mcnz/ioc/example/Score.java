package com.mcnz.ioc.example;

public class Score {

	private int wins, losses, ties;

	@Override
	public String toString() {
		return "Score [wins=" + wins + ", losses=" + losses + ", ties=" + ties + "]";
	}

	// Getters
	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public int getTies() {
		return ties;
	}

	// Methods to increment scores
	public void increaseWins() {
		this.wins++;
	}

	public void increaseLosses() {
		this.losses++;
	}

	public void increaseTies() {
		this.ties++;
	}
}