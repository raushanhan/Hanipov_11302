public class GameWithHuman extends AbstractGame{
	
	public GameWithHuman(int maxHP) {
		super(maxHP);
		
		Log.out("Enter name of the 2st Player");
		String name = in.nextLine();
		
		Log.out("Does the 2st Player want to be a Healer? (Enter \"yes\" if yes, anything else otherwise)");
		if (in.nextLine().equals("yes")) {
			p2 = new HealerPlayer(name, maxHP);
		}
		else {
			p2 = new Player(name, maxHP);
		}
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
			
			if (kicker instanceof HealerPlayer) {
				if (kicker.getHP() == 100) {
					Log.out(kicker.getName() + "'s hp is full, no healing possible");
				} else {
					Log.out(kicker + " is going to heal themselves with amount of hp of: ");
					int h = in.nextInt();
					while (f > 10 | f < 1) {
						Log.out("You entered an invalid value. Count of health points must be from 1 to 10. Try again.");
						h = in.nextInt();
					}
					
					result = kicker.heal(h);
					if (result) {
						Log.out("Succes, " + kicker.getName() + "'s hp increased to " + kicker.getHP() + ".");
					} else {
						Log.out("Unsuccessful healing.");
					}
				}
			}
		}
	}
	

}

/*if (enemy instanceof HealerPlayer) {
				Log.out("How much health points out of " + enemy.getHP + " does the " + enemy.getName() + "want to regain?");
				int h = in.nextInt();
				while (h >= enemy.getHP) {
					Log.out("You entered an invalid value. The HP must be from less than " + enemy.getHP + ". Try again.");
					int h = in.nextInt();
				}
				
				Log.out(enemy.getName() + "'s hp is now " + enemy.getHP() + ".");
			}*/