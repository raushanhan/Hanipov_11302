import java.util.Scanner;

public class Subscription {
	
	private int user1_id;
	private int user2_id;
	
	public Subscription(int user1_id, int user2_id) {
		this.user1_id = user1_id;
		this.user2_id = user2_id;
	}

	public int[] getId() {
		int[] arr = {user1_id, user2_id};
		return arr;
	}
	
	public String toString() {
		return "User " + user1_id + " subscribes " + user2_id;
	}

}