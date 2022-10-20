package utilclass;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Eproduct;

public class Hibernateutil {
	public static SessionFactory sessionfactory=null;
	public static SessionFactory buildsessionfactory() {
	new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Eproduct.class);
		return sessionfactory;
	}
}
