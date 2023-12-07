import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Task1 {
	
	public static void main (String [] args) throws FileNotFoundException {
		
		Scanner userSc = new Scanner(new File("Users.txt"));
		Scanner subSc = new Scanner(new File("Subscriptions.txt"));
		
		int usersNum = userSc.nextInt();
		int subsNum = subSc.nextInt();
		
		userSc.nextLine();
		subSc.nextLine();
		
		User[] users = new User[usersNum];
		Subscription[] subs = new Subscription[subsNum];
		
		for (int i = 0; i < usersNum; i++) {
			String[] userAttributes = userSc.nextLine().split(" ");
			int id = Integer.parseInt(userAttributes[0]);
			String name = userAttributes[1];
			String city = userAttributes[2];
			users[i] = new User(id, name, city);
			System.out.println(users[i]);
		}
		
		for (int i = 0; i < subsNum; i++) {
			String[] subsAttributes = subSc.nextLine().split(" ");
			int firstId = Integer.parseInt(subsAttributes[0]);
			int secondId = Integer.parseInt(subsAttributes[1]);
			subs[i] = new Subscription(firstId, secondId);
			System.out.println(subs[i]);
		}
		
	}
	
}