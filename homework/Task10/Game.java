import java.util.Scanner;

public class Game {
	
	private Player p1, p2;
	private Scanner in = new Scanner(System.in);
	
	public Game(int maxHP) {
		Log.out("Enter name of 1st Player");
		p1 = new Player(in.nextLine(), maxHP);
		Log.out("Enter name of 2st Player");
		p2 = new Player(in.nextLine(), maxHP);
	}
	
	public void go() {
		Log.out("The battle has begun.");
		Player kicker = p1;
		Player enemy = p2;
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
			
			Player swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
		Player winner = p1.alive() ? p1 : p2;
		Log.out(winner.getName() + " won.");
	}
	
	public static void main (String [] args) {
		final int MAX_HP = args.length == 1 ? Integer.parseInt(args[0]) : 100;
		Game g = new Game(MAX_HP);
		g.go();
	}
}