public abstract class Bot extends AbstractPlayer {
	
	public Bot(int maxHP) {
		super(maxHP);
		this.name = "Just Bot";
	}
	
	public abstract boolean kick(AbstractPlayer ap);
	
	public abstract boolean heal(int h);
}