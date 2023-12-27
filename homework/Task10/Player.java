public class Player {
	
	private String name;
	private int hp;
	
	public Player(String name, int maxHP) {
		hp = maxHP;
		this.name = name;
	}
	
	public boolean kick (Player enemy, int f) {
		
		double d = (f - 1.0) / 10;
		if (Math.random() > d) {
			enemy.hp -= f;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean alive () {
		return hp > 0;
	}
		
	public String toString() {
		return (name + "(" + hp + ")");
	}
	
	public String getName() {
		return name;
	}
		
	public String getHP() {
		return hp + "";
	}
}
