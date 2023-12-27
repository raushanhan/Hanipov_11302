package models;

public class Membership {
	
	private User user;
	private Group group;
	
	
	public Membership(User user, Group group) {
		this.user = user;
		this.group = group;
	}

	public User getUser() {
		return user;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public String toString() {
		return user + " is a member of " + group;
	}
	
}