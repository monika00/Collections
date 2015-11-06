package Hibernate_maventry.HQL;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class Program_HQL {
	
	public static void main(String[] args){
		System.out.println("Hello World");
		
		PopulateSampleData();
		
		Session session = HibernateUtilities_HQL.getSessionFactory().openSession();
		session.beginTransaction();
		
//		Query query = session.createQuery("select user_hql from User_HQL as user_hql where user_hql.name= :name").setString("name", "Kamtas");
//		Query query = session.createQuery("select goalalert_hql from GoalAlert_HQL as goalalert_hql");
//		Query query = session.getNamedQuery("AllGoalAlerts");
		
		Criteria criteria = session.createCriteria(User_HQL.class);
		
		
		List<User_HQL> users = criteria.list();
		for(User_HQL user : users){
			System.out.println(user.getName());
		}
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtilities_HQL.getSessionFactory().close();
	}
	
	private static void PopulateSampleData(){
		
		Session session = HibernateUtilities_HQL.getSessionFactory().openSession();
		session.beginTransaction();
		
		User_HQL kamtas = CreateUser("Kamtas", 500, 50, "Good Job", "You made it!");
		session.save(kamtas);
		
		User_HQL mantas = CreateUser("Mantas", 300, 20, "Ta mtias");
		session.save(mantas);
		
		User_HQL tautas = CreateUser("Tautas", 250, 200, "Yopaas!");
		session.save(tautas);
		session.getTransaction().commit();
		session.close();
		
	}
	
	private static User_HQL CreateUser(String name, int goal, int total, String ... alerts){
		User_HQL user = new User_HQL();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory_HQL(new Date(), "Set goal to" + goal));
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory_HQL(new Date(), "Set total to" + total));
		for(String alert : alerts){
			user.getGoalAlerts().add(new GoalAlert_HQL(alert));
		}
		
		return user;
	}
}
