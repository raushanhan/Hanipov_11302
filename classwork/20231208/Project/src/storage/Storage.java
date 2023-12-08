package services;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import models.*;

public class Storage {
	
	private User[] users;
	private Subscription[] subs;
	
	public Storage() {}
	
	public void init() throws FileNotFoundException{
		
		Scanner scUsers = new Scanner(new File("Users.txt"));
		int n = scUsers.nextInt();
		scUsers.nextLine();
		
		users = new User[n];
		
		for (int i = 0; i < n; i++) {
			String[] userAttributes = scUsers.nextLine().split(" ");
			int id = Integer.parseInt(userAttributes[0]);
			String name = userAttributes[1];
			String city = userAttributes[2];
			users[i] = new User(id, name, city);
		}
		
		Scanner scSubs = new Scanner(new File("Subscriptions.txt"));
		n = scSubs.nextInt();
		scSubs.nextLine();
		
		subs = new Subscription[n];
		
		for (int i = 0; i < n; i++) {
			String[] subsAttributes = scSubs.nextLine().split(" ");
			User user1 = this.getUserById(Integer.parseInt(subsAttributes[0]));
			User user2 = this.getUserById(Integer.parseInt(subsAttributes[1]));
			subs[i] = new Subscription(user1, user2);
		}
	}
	
	public User getUserById(int id) {
		for (int i = 0; i < users.length; i++) {
			if (users[i].getId() == id) {
				return users[i];
			}
		}
		return null;
	}
	
	public User[] getUsers() {
		return users;
	}
	
	public Subscription[] getSubs() {
		return subs;
	}
	
}