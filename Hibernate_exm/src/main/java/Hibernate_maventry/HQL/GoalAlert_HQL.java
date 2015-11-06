package Hibernate_maventry.HQL;

public class GoalAlert_HQL {
	
	private int id;
	private String message;
	
	
	public GoalAlert_HQL(String message) {
		super();
		this.message = message;
	}
	
	public GoalAlert_HQL(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
