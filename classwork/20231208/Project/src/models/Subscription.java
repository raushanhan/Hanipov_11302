package models;

public class Subscription {
	
	private User user1;
	private User user2;
	
	public Subscription(User user1, User user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	public User getUser1() {
		return user1;
	}
	
	public User getUser2() {
		return user2;
	}
	
	public String toString() {
		return user1 + " subscribes " + user2;
	}

}