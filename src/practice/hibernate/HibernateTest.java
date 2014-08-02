package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
	
				
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		//CREATE
		/*for(int i=0;i<10;i++){
			UserDetails user=new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}*/
		
		//READ
		UserDetails user=(UserDetails)session.get(UserDetails.class, 5);
		
		//UPDATE
		user.setUserName("Updated UserName");
		session.update(user);
		//DELETE
		//session.delete(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
