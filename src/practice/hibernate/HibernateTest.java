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
		
		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		List <String>users=(List<String>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Users: "+users.size());
		for (String u:users){
			System.out.println(u);
		}
			}

}
