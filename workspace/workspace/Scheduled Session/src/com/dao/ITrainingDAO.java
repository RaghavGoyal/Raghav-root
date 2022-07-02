package com.dao;

import java.util.List;

import com.entity.Session;

public interface ITrainingDAO {
	
	public abstract List<Session> getAllSessions();
	
	public abstract String getSessionName(int id);
	
}