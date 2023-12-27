public class HealerPlayer extends Player {
	
	public HealerPlayer(String name, int maxHP) {
		super(name, maxHP);
	}
	
	public boolean heal(int h) {
		double d = (h - 1.0) / 10;
		if (Math.random() > d) {
			if (hp + h > 100) {
				h = 100;
			}
			else {
				hp += h;				
			}
			return true;
		} else {
			return false;
		}
	}
}