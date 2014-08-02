package practice.hibernate;

import java.util.List;

import org.hibernate.Query;
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
		
		String minUserId=" 5 or 1=1";
		Query query = session.createQuery("from UserDetails where userId >"+minUserId);
		
		List <UserDetails>users=(List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Users: "+users.size());
		for (UserDetails u:users){
			System.out.println(u.getUserName());
		}
			}

}
