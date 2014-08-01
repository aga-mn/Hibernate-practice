package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.Address;
import practice.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("New User");
		
		Address addr = new Address();
		addr.setCity("Warsaw");
		addr.setStreet("Street");
		addr.setPincode("12345");
		addr.setState("State");
		
		Address addr2=new Address();
		addr2.setCity("City 2");
		addr2.setStreet("Street 2");
		addr2.setPincode("54321");
		addr2.setState("Another State");
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
					
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);						//insert
		session.getTransaction().commit();
		session.close();
		

	}

}
