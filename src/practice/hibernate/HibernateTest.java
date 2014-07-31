package practice.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First User's Address");
		user.setDescription("Description of the user goes here");
		user.setJoinedDate(new Date());
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		

	}

}
