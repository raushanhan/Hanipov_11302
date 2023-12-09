package services;

import models.*;
import storage.*;

public class Service {
	
	private IStorage db;
	
	public Service(IStorage db) {
		this.db = db;
	}
	
	public User[] getUsers() {
		return db.getUsers();
	}
	
	public Subscription[] getSubs() {
		return db.getSubs();
	}
	
	public Group[] getGroups() {
		return db.getGroups();
	}
	
	public Membership[] getMembs() {
		return db.getMembs();
	}
	
	public boolean usersAreFriends(User user1, User user2) {
		if (user1.getId() == user2.getId()) {
			return true;
		}
		
		Subscription[] subs = getSubs();
		
		boolean user1FriendsToUser2 = false;
		boolean user2FriendsToUser1 = false;
		
		int id1 = user1.getId();
		int id2 = user2.getId();
		
		for (Subscription sub : subs) {
			if (sub.getUser1().getId() == id1 & sub.getUser2().getId() == id2) {
				user1FriendsToUser2 = true;
			} else if (sub.getUser2().getId() == id1 & sub.getUser1().getId() == id2) {
				user2FriendsToUser1 = true;
			}
		}
		return user1FriendsToUser2 & user2FriendsToUser1;
	}
	
	public User[] getGroupMembs(Group group) {
		Membership[] membs = getMembs();
		int membsCount = 0;
		for (Membership memb : membs) {
			if (memb.getGroup().getId() == group.getId()) {
				membsCount++;
			}
		}
		
		User[] groupMembs = new User[membsCount];
		int i = 0;
		for (Membership memb : membs) {
			if (memb.getGroup().getId() == group.getId()) {
				groupMembs[i] = memb.getUser();
				i++;
			}
		}
		return groupMembs;
	}
	
	public boolean allGroupMembersFriends(Group group) {
		User[] groupMembs = getGroupMembs(group);
		for (int i = 0; i < groupMembs.length; i++) {
			for (int j = i; j < groupMembs.length; j++) {
				if (!usersAreFriends(groupMembs[i], groupMembs[j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*public boolean allGroupMembersOneFriend(Group group) {
		
	}
	
	public boolean groupMemebersChainBuildable(Group group) {
		
	}
	
	public boolean groupIsFriendly(Group group) {
		
	}*/
	
}