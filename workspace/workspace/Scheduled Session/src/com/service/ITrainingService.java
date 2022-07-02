package com.service;

import java.util.List;

import com.entity.Session;

public interface ITrainingService {
	
	public abstract List<Session> getAllSessions();
	
	public abstract String getSessionName(int id);
	
}