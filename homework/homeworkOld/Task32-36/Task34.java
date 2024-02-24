import models.*;
import services.*;
import storage.*;

public class Task34 {
	
	public static void main(String [] args) {
		IStorage db1 = new MockStorage();
		IStorage db2 = new FileStorage();
		try {
			db1.init();
			db2.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Service s = new Service(db1);
		User [] users = s.getUsers();
		Subscription [] subs = s.getSubs();
		Group [] groups = s.getGroups();
		Membership [] membs = s.getMembs();
		
		int friendlyGroupsCountCriteria1 = 0;
		for (int i = 0; i < groups.length; i++) {
			if (s.allGroupMembersFriends(groups[i])) {
				friendlyGroupsCountCriteria1++;
			}
		}
		
		System.out.println("percentage of groups friendly by the first criteria is " + 
						friendlyGroupsCountCriteria1 / groups.length * 100 + "%");
	
	}
	
}