package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.UserDetails;
import practice.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("New User");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		user.setVehicle(vehicle);
					
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);						//insert
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		
		

	}

}
