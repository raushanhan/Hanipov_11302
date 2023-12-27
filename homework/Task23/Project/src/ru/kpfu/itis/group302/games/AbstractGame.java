package ru.kpfu.itis.group302.games;

import ru.kpfu.itis.group302.log.Log;
import ru.kpfu.itis.group302.players.*;

import java.util.Scanner;

public abstract class AbstractGame {
	
	protected AbstractPlayer p1, p2;
	protected Scanner in = new Scanner(System.in);
	
	public AbstractGame(int maxHP) {
		Log.out("Enter name of 1st Player");
		p1 = new Player(in.nextLine(), maxHP);
	}
	
	public abstract void gameProcess();
	
	public void go() {
		start();
		gameProcess();
		end();
	}
	
	public void start() {
		Log.out("The battle has begun");
	}
	
	public void end() {
		AbstractPlayer winner = p1.alive() ? p1 : p2;
		Log.out(winner.getName() + "won. ");
	}
}