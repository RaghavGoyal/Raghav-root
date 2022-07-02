package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scheduledsessions")
public class Session {
	
	@Id
    @Column(name="ID")
    @GeneratedValue
	int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="duration")
	int duration;
	
	@Column(name="faculty")
	String faculty;
	
	@Column(name="mode1")
	String model;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

}
