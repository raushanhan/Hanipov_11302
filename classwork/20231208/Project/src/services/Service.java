package services;

import storage.*;

public class Services {
	
	private User[] users;
	private Subscription[] subs;
	
	public Service(Storage db) {
		this.users = db.getUsers();
		this.subs = db.getSubs();
	}
	
	public int find() {
		
	}
}