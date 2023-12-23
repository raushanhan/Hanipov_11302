public abstract class AbstractTwoTeamGame {
	
	protected Team team1;
	protected Team team2;
	
	public abstract void play();
	
	public AbstractTwoTeamGame(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}
	
	public class String printWinner() {
		return Team + " has won!";
	}
}