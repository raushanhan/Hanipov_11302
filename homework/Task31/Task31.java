import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task31 {

	public static Group[] scanGroups(Scanner sc) {
		int n = sc.nextInt();
		sc.nextLine();
		
		Group[] groups = new Group[n];
		
		for (int i = 0; i < n; i++) {
			String[] groupAttributes = sc.nextLine().split(" ");
			int id = Integer.parseInt(groupAttributes[0]);
			String name = groupAttributes[1];
			String city = groupAttributes[2];
			groups[i] = new Group(id, name, city);
		}
		return groups;
	}
	
	public static User[] scanUsers(Scanner sc) {
		int n = sc.nextInt();
		sc.nextLine();
		
		User[] users = new User[n];
		
		for (int i = 0; i < n; i++) {
			String[] userAttributes = sc.nextLine().split(" ");
			int id = Integer.parseInt(userAttributes[0]);
			String name = userAttributes[1];
			String city = userAttributes[2];
			users[i] = new User(id, name, city);
		}
		return users;
	}
	
	public static Membership[] scanMemberships(Scanner sc) {
		int n = sc.nextInt();
		sc.nextLine();
		
		Membership[] mems = new Membership[n];
		
		for (int i = 0; i < n; i++) {
			String[] memAttributes = sc.nextLine().split(" ");
			int firstId = Integer.parseInt(memAttributes[0]);
			int secondId = Integer.parseInt(memAttributes[1]);
			mems[i] = new Membership(firstId, secondId);
		}
		return mems;
	}
	
	public static boolean contains(int[] arr, int num) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static String getGroupCity(Group[] groups, int id, int len) {
		for (int i = 0; i < len; i++) {
			if (groups[i].getId() == id) {
				return groups[i].getCity();
			}
		}
		return "";
	}
	
	public static String getUserCity(User[] users, int id, int len) {
		for (int i = 0; i < len; i++) {
			if (users[i].getId() == id) {
				return users[i].getCity();
			}
		}
		return "";
	}
	
	public static String getName(Group[] groups, int id, int len) {
		for (int i = 0; i < len; i++) {
			if (groups[i].getId() == id) {
				return groups[i].getName();
			}
		}
		return "";
	}
	
	public static void main (String [] tassr) throws FileNotFoundException {
		
		User[] users = scanUsers(new Scanner(new File("Users.txt")));
		Group[] groups = scanGroups(new Scanner(new File("Groups.txt")));
		Membership[] mems = scanMemberships(new Scanner(new File("Memberships.txt")));
		
		int usersQ = users.length;
		int memsQ = mems.length;
		int groupsQ = groups.length;
		
		boolean groupNoSameCityFollowers = false;
		int current = -1;
		
		for (int i = 0; i < memsQ; i++) {
			if (current == mems[i].getId()[0]) {
				continue;
			}
			current = mems[i].getId()[0];
			int flws = 0;
			int j = 0;
			while(j < memsQ & flws == 0) {
				if (mems[j].getId()[0] == current) {
					String city1 = getGroupCity(groups, current, groupsQ);
					String city2 = getUserCity(users, mems[j].getId()[1], usersQ);
					if (city1.equals(city2)) {
						flws++;
					}
				}
				j++;
			}

			if (flws == 0) {
				groupNoSameCityFollowers = true;
				System.out.println(getName(groups, current, groupsQ));
			}
		}
		
		if (!groupNoSameCityFollowers) {
			System.out.println("no such group");
		}
	}
}