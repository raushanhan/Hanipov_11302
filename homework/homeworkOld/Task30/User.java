import java.util.Scanner;

public class User {
	
	private int id;
	private String name;
	private String city;
	
	public User(int id) {
		this.id = id;
		name = "NoName";
		city = "NoCity";
	}
	
	public User(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public String toString() {
		return "User " + id + " " + name + " from " + city;
	}
	
	public String getName() {
		return name;
	}
	
	/*public void setName(String name) {
		this.name = name;
	}*/
	
	public String getCity() {
		return city;
	}
	
	/*public void setCity(String city) {
		this.city = city;
	}*/
	
	public int getId() {
		return id;
	}
	
	
	/*public void setId(int id) {
		this.id = id;
	}*/
}