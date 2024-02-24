package ru.kpfu.itis.group302.games;

import ru.kpfu.itis.group302.players.*;
import ru.kpfu.itis.group302.log.Log;


public class GameWithHuman extends AbstractGame{
	
	public GameWithHuman(int maxHP) {
		super(maxHP);
		Log.out("Enter name of the 2nd Player");
		p2 = new Player(in.nextLine(), maxHP);
	}

	public void gameProcess() {
		AbstractPlayer kicker = p1;
		AbstractPlayer enemy = p2;
		while (p1.alive() && p2.alive()) {
			Log.out(kicker + " is going to kick " + enemy + " with force: ");
			int f = in.nextInt();
			while (f > 10 | f < 1) {
				Log.out("You entered an invalid value. The force must be from 1 to 10. Try again.");
				f = in.nextInt();
			}
			
			boolean result = kicker.kick(enemy, f);
			if (result) {
				Log.out("Succes, " + enemy.getName() + "'s hp is " + enemy.getHP() + ".");
			} else {
				Log.out("Missed");
			}
			AbstractPlayer swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
	}
}