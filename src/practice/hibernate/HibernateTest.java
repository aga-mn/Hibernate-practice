package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.UserDetails;
import practice.dto.Vehicle;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("My User");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("Different Car");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.persist(user);	
		
		session.getTransaction().commit();
		session.close();
		
		

	}

}
