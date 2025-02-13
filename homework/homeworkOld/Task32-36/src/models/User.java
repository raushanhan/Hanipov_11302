package models;

public class User {
	
	private int id;
	private String name;
	private String city;
	
	public User(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public String toString() {
		return "user " + id + " " + name + " from " + city;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getId() {
		return id;
	}
	
}