package Hibernate_maventry.Entity;

import java.util.Date;

public class UserHistory {
	
	private Date entryTime;
	private String entry;
	private int id;
	private User_E user;

	public UserHistory(){};
	

	public UserHistory(Date entryTime, String entry) {
		super();
		this.entryTime = entryTime;
		this.entry = entry;
	}
	
	
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	
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

}
