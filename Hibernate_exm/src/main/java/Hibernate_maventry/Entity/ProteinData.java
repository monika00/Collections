package Hibernate_maventry.Entity;

public class ProteinData {
	
	private int id;
	private User_E user;
	private int total;
	private int goal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User_E getUser() {
		return user;
	}
	public void setUser(User_E user) {
		this.user = user;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
}
