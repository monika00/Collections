package Hibernate_maventry.HQL;

import java.util.Date;

public class UserHistory_HQL {
	
	private Date entryTime;
	private String entry;
	private int id;
	private User_HQL user;

	public UserHistory_HQL(){};
	

	public UserHistory_HQL(Date entryTime, String entry) {
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

	public User_HQL getUser() {
		return user;
	}

	public void setUser(User_HQL user) {
		this.user = user;
	}

}
