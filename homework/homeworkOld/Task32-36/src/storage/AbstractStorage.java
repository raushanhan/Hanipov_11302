package storage;

import models.*;
import java.io.FileNotFoundException;

public abstract class AbstractStorage implements IStorage {
	
	protected Group [] groups;
	protected User[] users;
	protected Subscription[] subs;
	protected Membership[] membs;
	
	public abstract void init() throws FileNotFoundException;
	
	public Group [] getGroups() {
		return groups;
	}
	
	public User[] getUsers() {
		return users;
	}
	
	public Subscription[] getSubs() {
		return subs;
	}
	
	public Membership[] getMembs() {
		return membs;
	}
	
	public User getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public Group getGroupById(int id) {
		for (Group group : groups) {
			if (group.getId() == id) {
				return group;
			}
		}
		return null;
	}
}