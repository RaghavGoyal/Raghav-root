package com.hib.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap <String,String> mapobj=new HashMap <String,String>();
		int count=3;
		
		mapobj.put("Raghav","Mathura");
		mapobj.put("xyz","Mathura");
		
		Set set = (Set) mapobj.entrySet();
		Iterator iterator = set.iterator();
		Configuration cfg= new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		BeanClass obj=new BeanClass();

		while (iterator.hasNext())
		{
			Map.Entry mapEntry = (Map.Entry) iterator.next();
			String keyValue = (String) mapEntry.getKey();
			String Value = (String) mapEntry.getValue();
			obj.setId(count);
			obj.setName(keyValue);
			obj.setAddress(Value);
			count++;
			
		}
		
		Transaction t=s.beginTransaction();
		s.save(obj);
		t.commit();
		
		

	}

}
