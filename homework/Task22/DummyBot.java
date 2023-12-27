public class DummyBot extends Bot {
	
	private int force = 2;
	
	public DummyBot(int maxHP) {
		super(maxHP);
		this.name = "I'm dummy";
	}
	
	public boolean kick(AbstractPlayer ap) {
		return this.kick(ap, force);
	}
	
	public abstract boolean heal(int h) {
		return false;
	}
}