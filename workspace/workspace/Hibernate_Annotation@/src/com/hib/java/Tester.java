package com.hib.java;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hib.java.*;


@SuppressWarnings("unused")
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//first one.
				Configuration cfg= new Configuration();
				cfg.configure("hibernate.cfg.xml");
				
				SessionFactory sf=cfg.buildSessionFactory();
				Session s=sf.openSession();
				BeanClass obj=new BeanClass();
				obj.setId(7);
				obj.setName("java");
				obj.setAddress("noida");
				
				Transaction t=s.beginTransaction();
				s.save(obj);
				t.commit();
				s.close();
				sf.close();
				
				
				
				//second one
				//Configuration cfg2= new Configuration();
				//cfg2.configure("hibernate.cfg.xml");
				
				sf=cfg.buildSessionFactory();
				s=sf.openSession();
				BeanClass2 obj2=new BeanClass2();
				obj2.setId(8);
				obj2.setName("java");
				obj2.setPwd("MYPassword");
				obj2.setAddress("Gr. Noida");
				
				t=s.beginTransaction();
				s.save(obj2);
				t.commit();


	}

}
