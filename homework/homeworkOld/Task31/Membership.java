public class Membership {
	
	private int userId;
	private int groupId;
	
	public Membership(int userId, int groupId) {
		this.userId = userId;
		this.groupId = groupId;
	}

	public int[] getId() {
		int[] arr = {userId, groupId};
		return arr;
	}
	
	public String toString() {
		return "User " + userId + " is a member of group " + groupId;
	}
	
}