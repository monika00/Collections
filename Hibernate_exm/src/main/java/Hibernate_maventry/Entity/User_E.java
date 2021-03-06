package Hibernate_maventry.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User_E {
	
	private int id;
	private String name;
	
	private ProteinData proteinData;
	private List<UserHistory> history = new ArrayList<UserHistory>();
	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();
	
	public Set<GoalAlert> getGoalAlerts() {
		return goalAlerts;
	}

	public void setGoalAlerts(Set<GoalAlert> goalAlerts) {
		this.goalAlerts = goalAlerts;
	}

	public User_E(){
		setProteinData(new ProteinData());
	}
	
	public List<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}

	public void addHistory(UserHistory historyItem){
		historyItem.setUser(this);
		history.add(historyItem);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}
}
