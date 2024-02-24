package storage;

import models.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class FileStorage extends AbstractStorage {
	
	public void init() throws FileNotFoundException {
		this.initUsers(new File("Users.txt"));
		this.initSubs(new File("Subscriptions.txt"));
		this.initGroups(new File("Groups.txt"));
		this.initMembs(new File("Memberships.txt"));
	}
	
	
	public void initUsers(File file) throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		sc.nextLine();
		
		users = new User[n];
		
		for (int i = 0; i < n; i++) {
			String[] userAttributes = sc.nextLine().split(" ");
			int id = Integer.parseInt(userAttributes[0]);
			String name = userAttributes[1];
			String city = userAttributes[2];
			users[i] = new User(id, name, city);
		}
	}
	
	public void initGroups(File file) throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		sc.nextLine();
		
		groups = new Group[n];
		
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			int id = Integer.parseInt(str[0]);
			String name = str[1];
			String city = str[2];
			User admin = this.getUserById(Integer.parseInt(str[3]));
			Group group = new Group(id, name, city, admin);
			this.groups[i] = group;
		}
	}
	
	public void initSubs(File file) throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		sc.nextLine();
		
		subs = new Subscription[n];
		
		for (int i = 0; i < n; i++) {
			String[] subsAttributes = sc.nextLine().split(" ");
			User user1 = this.getUserById(Integer.parseInt(subsAttributes[0]));
			User user2 = this.getUserById(Integer.parseInt(subsAttributes[1]));
			subs[i] = new Subscription(user1, user2);
		}
	}
	
	public void initMembs(File file) throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		sc.nextLine();
		
		membs = new Membership[n];
		
		for (int i = 0; i < n; i++) {
			String[] str = sc.nextLine().split(" ");
			User user = this.getUserById(Integer.parseInt(str[0]));
			Group group = this.getGroupById(Integer.parseInt(str[1]));
			Membership member = new Membership(user, group);
			this.membs[i] = member;
		}
	}
}