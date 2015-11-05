package Hibernate_maventry.Entity;

import java.util.Date;

import org.hibernate.Session;

public class Program {
	
	public static void main(String[] args){
		
		System.out.println("Hello world");
		Session session = (Session) HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User_E user = new User_E();
		user.setName("Kamtas");
		user.addHistory(new UserHistory(new Date(), "Set name to Kamtas"));
		user.getProteinData().setGoal(1);
		user.addHistory(new UserHistory(new Date(), "Set the goal to 1"));
		user.getProteinData().setTotal(5);
		user.getGoalAlerts().add(new GoalAlert("Congratulations!"));
		user.getGoalAlerts().add(new GoalAlert("You did it!"));

		
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User_E loadedUser = (User_E) session.get(User_E.class, 1);
		System.out.println(loadedUser.getName());
		System.out.println(loadedUser.getProteinData().getGoal());
		for(UserHistory history : loadedUser.getHistory()){
			System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
		}
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal()+50);
		loadedUser.addHistory(new UserHistory(new Date(), "Addeed 50 protein"));
		
		user.setProteinData(new ProteinData());
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
