import models.*;
import services.*;
import storage.*;

public class Main {
	
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
		
		/*for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}*/
		
		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i]);
			System.out.println(s.allGroupMembersFriends(groups[i]));
		}
		
		/*for (int i = 0; i < d.length; i++) {
			System.out.println(d[i]);
		}*/
	
	}
	
}