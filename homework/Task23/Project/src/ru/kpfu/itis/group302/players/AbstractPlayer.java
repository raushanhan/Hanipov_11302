package ru.kpfu.itis.group302.players;

public abstract class AbstractPlayer {
	
	protected int hp;
	protected String name;
	
	public AbstractPlayer(int maxHP) {
		hp = maxHP;
	}
	
	public AbstractPlayer(String name, int maxHP) {
		this.name = name;
		hp = maxHP;
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
	
	public boolean alive () {
		return hp > 0;
	}
	
	public boolean kick(AbstractPlayer enemy, int f) {	
		double d = (f - 1.0) / 10;
		if (Math.random() > d) {
			enemy.hp -= f;
			return true;
		} else {
			return false;
		}
	}

}
