import java.util.Scanner;

public abstract class AbstractGame {
	
	protected AbstractPlayer p1, p2;
	protected Scanner in = new Scanner(System.in);
	
	public AbstractGame(int maxHP) {
		
		Log.out("Enter name of 1st Player");
		String name = in.nextLine();
		
		Log.out("Does the 1st Player want to be a Healer? (Enter \"yes\" if yes, anything else otherwise)");
		if (in.nextLine().equals("yes")) {
			p1 = new HealerPlayer(name, maxHP);
		}
		else {
			p1 = new Player(name, maxHP);
		}
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