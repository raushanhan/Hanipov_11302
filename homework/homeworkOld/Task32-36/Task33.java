import models.*;
import services.*;
import storage.*;

public class Task33 {
	
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
		
		for (Group g : groups) {
			if (s.halfMembersNotAdminCity(g)) {
				System.out.println(g);
			}
		}
	
	}
	
}