package Hibernate_maventry.HB;

import java.util.ArrayList;
import java.util.Collection;


public class User {
	
	private int id;
	private String name;
	
	private ProteinData proteinData = new ProteinData();
//  -----------SET Example----------------------------------
//	private Set<UserHistory> history = new HashSet<UserHistory>();
//	public Set<UserHistory> getHistory() {
//		return history;
//	}
//	public void setHistory(Set<UserHistory> history) {
//		this.history = history;
//	}
	
// -------------LIST example----------------------------------
//	private List<UserHistory> history = new ArrayList<UserHistory>();
//	public List<UserHistory> getHistory() {
//		return history;
//	}
//	public void setHistory(List<UserHistory> history) {
//		this.history = history;
//	}
//  -----------MAP example--------------------------------------
//	private Map<String, UserHistory> history = new HashMap<String, UserHistory>();
//	public Map<String, UserHistory> getHistory() {
//		return history;
//	}
//	public void setHistory(Map<String, UserHistory> history) {
//		this.history = history;
//	}
	
	private Collection<UserHistory> history = new ArrayList<UserHistory>();
	
	public Collection<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(Collection<UserHistory> history) {
		this.history = history;
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
	}
}
