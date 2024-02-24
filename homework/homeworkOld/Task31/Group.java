public class Group {
	
	private int id;
	private String name;
	private String city;
	
	public Group(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public String toString() {
		return "group " + id + " " + name + " from " + city;
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