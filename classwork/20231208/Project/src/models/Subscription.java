package models;

public class Subscription {
	
	private User user1;
	private User user2;
	
	public Subscription(User user1, User user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	public User[] getId() {
		User[] arr = {user1, user2};
		return arr;
	}
	
	public String toString() {
		return user1 + " subscribes " + user2;
	}

}