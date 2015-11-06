package Hibernate_maventry.HQL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User_HQL {
	
	private int id;
	private String name;
	
	private ProteinData_HQL proteinData;
	private List<UserHistory_HQL> history = new ArrayList<UserHistory_HQL>();
	private Set<GoalAlert_HQL> goalAlerts = new HashSet<GoalAlert_HQL>();
	
	public Set<GoalAlert_HQL> getGoalAlerts() {
		return goalAlerts;
	}

	public void setGoalAlerts(Set<GoalAlert_HQL> goalAlerts) {
		this.goalAlerts = goalAlerts;
	}

	public User_HQL(){
		setProteinData(new ProteinData_HQL());
	}
	
	public List<UserHistory_HQL> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory_HQL> history) {
		this.history = history;
	}

	public void addHistory(UserHistory_HQL historyItem){
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
	public ProteinData_HQL getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData_HQL proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}
}
