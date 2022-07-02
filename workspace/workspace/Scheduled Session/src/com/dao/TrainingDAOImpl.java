package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Session;

@Repository
public class TrainingDAOImpl implements ITrainingDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getAllSessions() {
		return this.sessionFactory.getCurrentSession().createQuery("from Session").list();
	}

	@Override
	public String getSessionName(int id) {
		// TODO Auto-generated method stub
		Session s =  (Session) this.sessionFactory.getCurrentSession().createQuery("from Session where id="+id).list().get(0);
		System.out.println(""+s.getName());
		return s.getName();
	}
	
	
}
