package models;

public class Group {
	
	private int id;
	private String name;
	private String city;
	private User admin;
	
	public Group(int id, String name, String city, User admin) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.admin = admin;
	}
	
	public String toString() {
		return "group " + id + " " + name + " from " + city;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public User getAdmin() {
		return admin;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}