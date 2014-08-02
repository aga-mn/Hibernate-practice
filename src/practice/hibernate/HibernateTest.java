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
		
		String minUserId="7";
		String userName="User 10";
		
		/*Query query = session.createQuery("from UserDetails where userId > ? and userName = ?");
		query.setInteger(0, Integer.parseInt(minUserId));
		query.setString(1, userName);*/
		
		Query query = session.createQuery("from UserDetails where userId > :userId and userName= :userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		
		List <UserDetails>users=(List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Users: "+users.size());
		for (UserDetails u:users){
			System.out.println(u.getUserName());
		}
			}

}
