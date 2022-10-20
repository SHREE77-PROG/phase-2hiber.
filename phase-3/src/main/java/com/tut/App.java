package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		System.out.println("project started");
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		//creating student
		Student st= new Student();
		st.setId(101);
		st.setName("jhon");
		st.setCity("gajendragad");
		System.out.println(st);
		Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    session.save(st);
	    tx.commit();
	    session.close();
		/*Configuration cfg=new Configuration().configure();
		Configuration.addAnnotatedClass(com.tut.Student.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(Configuration.getProperties());
		SessionFactory factory=cfg.buildSessionFactory(builder.build());
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		Student st= new Student(101,"jhon","gajendragad");
		session.save(st);
		transaction.commit();
		session.close();*/
		
	}

}
