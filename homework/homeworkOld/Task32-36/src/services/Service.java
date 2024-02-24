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
			return false;
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
	
	public int getGroupMembsCount(Group group) {
		int membsCount = 0;
		for (Membership memb : getMembs()) {
			if (memb.getGroup().getId() == group.getId()) {
				membsCount++;
			}
		}
		return membsCount;
	}
	
	public User[] getGroupMembs(Group group) {
		int membsCount = getGroupMembsCount(group);
		
		User[] groupMembs = new User[membsCount];
		int i = 0;
		for (Membership memb : getMembs()) {
			if (memb.getGroup().getId() == group.getId()) {
				groupMembs[i] = memb.getUser();
				i++;
			}
		}
		return groupMembs;
	}
	
	public boolean allGroupMembersFriends(Group group) {
		User[] groupMembs = getGroupMembs(group);
		System.out.println(group);
		for (int i = 0; i < groupMembs.length; i++) {
			for (int j = i + 1; j < groupMembs.length; j++) {
				System.out.println(groupMembs[i] + " " + groupMembs[j]);
				if (!usersAreFriends(groupMembs[i], groupMembs[j])) {
					return false;
				}
			}
		}
		return true & groupMembs.length != 0;
	}
	
	public boolean allGroupMembersHaveOneFriend(Group group) {
		User[] groupMembs = getGroupMembs(group);
		System.out.println(group);
		for (int i = 0; i < groupMembs.length; i++) {
			boolean membHaveFriend = false;
			for (int j = i + 1; j < groupMembs.length; j++) {
				System.out.println(groupMembs[i] + " " + groupMembs[j]);
				if (usersAreFriends(groupMembs[i], groupMembs[j])) {
					membHaveFriend = true;
					break;
				}
			}
			if (!membHaveFriend) {
				return false;
			}
		}
		return true & groupMembs.length != 0;
	}
	
	public boolean intArrContains(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	public boolean halfMembersNotAdminCity(Group g) {
		
		User[] members = getGroupMembs(g);
		
		String adminCity = g.getCity();
		
		int sameCityMembersCount = 0;
		
		int i = 0;
		while ((sameCityMembersCount <= (double) members.length / 2) & i < members.length) {
			if (members[i].getCity().equals(adminCity)) {
				sameCityMembersCount++;
			}
			i++;
		}
		
		return sameCityMembersCount > (double) members.length / 2;
	}
	
	public boolean groupMembersChainBuildable(Group g) {
		
		// проверка по связности графа
		
		User [] members = getGroupMembs(g);
		int numberOfMembers = members.length;
		
		int nextNeighbour = 0;
		User [] queue = new User[numberOfMembers];
		int [] colored = new int[numberOfMembers];
		
		queue[nextNeighbour] = members[0];
		nextNeighbour++;
		int nextRead = 0;
		
		while (nextRead == nextNeighbour) {
			
			colored[nextRead] = queue[nextRead].getId();
			
			for (User u : members) {
				if (usersAreFriends(queue[nextRead], u)) {
					if (intArrContains(colored, u.getId())) {
						queue[nextNeighbour] = u;
						nextNeighbour++;
					}
				}
			}
		
			nextRead++;
		
		}
		
		return getGroupMembsCount(g) == nextNeighbour;
		
	}
	
}