package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mainclass {

	public static void main(String[] args) {
		user uuser=new user();
		uuser.setUserid(2);
		uuser.setUsername("kiruthi");
		uuser.setPassword("priya");
		
		SessionFactory sf=new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		Session s=sf.openSession();
		s.beginTransaction();
		s.save(uuser);
		s.getTransaction().commit();
         s.close();
	}

}
