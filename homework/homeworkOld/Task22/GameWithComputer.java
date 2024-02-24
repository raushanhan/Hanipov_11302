public class GameWithComputer extends AbstractGame {
	
	public GameWithComputer(int maxHP) {
		super(maxHP);
		p2 = new DummyBot(maxHP);
	}
	
	public void gameProcess() {
		Bot bot = (Bot) p2;
		while (p1.alive() && bot.alive()) {
			Log.out(p1 + " is going to kick " + bot + " with force: ");
			int f = in.nextInt();
			while (f > 10 | f < 1) {
				Log.out("You entered an invalid value. The force must be from 1 to 10. Try again.");
				f = in.nextInt();
			}
			
			boolean result = p1.kick(bot, f);
			Log.logResult(result, bot);
			
			Log.out(bot + " is going to kick " + p1 + " with force: ");
			result = bot.kick(p1, f);
			Log.logResult(result, p1);
		}
	}
}