package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.Address;
import practice.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		UserDetails user2=new UserDetails();
		user.setUserName("New User");
		user2.setUserName("User two");
		Address addr = new Address();
		addr.setCity("Warsaw");
		addr.setStreet("Street");
		user.setAddress(addr);
		user2.setAddress(addr);
			
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);						//insert
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		

	}

}
