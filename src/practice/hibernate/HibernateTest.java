package practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import practice.dto.FourWheeler;
import practice.dto.TwoWheeler;
import practice.dto.UserDetails;
import practice.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
	
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Vehicle");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steering handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Four Wheeler");
		car.setSteeringWheel("Car steering wheel");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.persist(vehicle);
		session.persist(car);
		session.persist(bike);
		session.getTransaction().commit();
		session.close();
		
		

	}

}
