package storage;

import java.io.FileNotFoundException;
import models.*;

public interface IStorage {
	User[] getUsers();
	Subscription[] getSubs();
	Group[] getGroups();
	Membership[] getMembs();
	User getUserById(int id);
	Group getGroupById(int id);
	void init() throws FileNotFoundException;

}