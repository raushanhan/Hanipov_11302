import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task1 {

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
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	public static Subscription[] scanSubs(Scanner sc) {
		int n = sc.nextInt();
		sc.nextLine();
		
		Subscription[] subs = new Subscription[n];
		
		for (int i = 0; i < n; i++) {
			String[] subsAttributes = sc.nextLine().split(" ");
			int firstId = Integer.parseInt(subsAttributes[0]);
			int secondId = Integer.parseInt(subsAttributes[1]);
			subs[i] = new Subscription(firstId, secondId);
		}
		return subs;
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
	
	public static String getCity(User[] users, int id, int len) {
		for (int i = 0; i < len; i++) {
			if (users[i].getId() == id) {
				return users[i].getCity();
			}
		}
		return "";
	}
	
	public static void main (String [] tassr) throws FileNotFoundException {
		
		User[] users = scanUsers(new Scanner(new File("Users.txt")));
		Subscription[] subs = scanSubs(new Scanner(new File("Subscriptions.txt")));
		
		int subsQ = subs.length;
		int usersQ = users.length;

		int max = 0;
		int current = -1;
		
		int maxsId = -1;
		
		for (int i = 0; i < subsQ; i++) {
			if (current == subs[i].getId()[0]) {
				continue;
			}
			current = subs[i].getId()[0];
			int flws = 0;
			for (int j = 0; j < subsQ; j++) {
				if (subs[j].getId()[0] == current) {
					String city1 = getCity(users, current, usersQ);
					String city2 = getCity(users, subs[j].getId()[1], usersQ);
					if (city1.equals(city2)) {
						flws++;
					}
				} else {
					continue;
				}
			}
			if (flws > max) {
				max = flws;
				maxsId = current;
			}
		}
		
		System.out.println(maxsId);
		
	}
	
}