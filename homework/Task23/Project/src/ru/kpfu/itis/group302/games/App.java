package ru.kpfu.itis.group302.games;

public class App {
	
	public static void main (String [] args) {
		final int MAX_HP = args.length == 1 ? Integer.parseInt(args[0]) : 100;
		
		
		AbstractGame g = new GameWithComputer(MAX_HP);
		g.go();
		
	}
	
}