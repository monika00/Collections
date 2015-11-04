package Hibernate_maventry.HB;

import java.util.Date;

import org.hibernate.Session;

public class Program {
	
	public static void main(String[] args){
		
		System.out.println("Hello world");
		Session session = (Session) HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("Kamtas");
		user.getHistory().add(new UserHistory(new Date(), "Set name to Kamtas"));
//		user.getHistory().put("GL123", new UserHistory(new Date(), "Set name to Kamtas")); - using map
		user.getProteinData().setGoal(1);
		user.getHistory().add(new UserHistory(new Date(), "Set the goal to 1"));
//		user.getHistory().put("GL124", new UserHistory(new Date(), "Set the goal to 1")); - using map
		user.getProteinData().setTotal(5);
		
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loadedUser = (User) session.get(User.class, 1);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		for(UserHistory history : loadedUser.getHistory()){
//		for(Entry<String, UserHistory> history : loadedUser.getHistory().entrySet()){ - using map
			System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
//			System.out.println("Key value: " + history.getKey()); 
//			System.out.println(history.getValue().getEntryTime().toString() + " " + history.getValue().getEntry()); - using map;
		}
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal()+50);
		loadedUser.getHistory().add(new UserHistory(new Date(), "Addeed 50 protein"));
//		loadedUser.getHistory().put("LG125",new UserHistory(new Date(), "Addeed 50 protein")); - using map
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
