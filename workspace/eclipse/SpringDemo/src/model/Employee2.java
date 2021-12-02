package model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// This bean/model is similar to Employee model;
// The only difference is in how bean life cycle is controlled.

// Here bean life cycle is controlled programmatically; rather than being controlled through XML.
// This is done by implementing following interfaces in the bean class:
//		1. InitializingBean (to control bean initialization)
//		2. DisposableBean (to control destruction of bean)

public class Employee2 implements InitializingBean, DisposableBean {
	
	int id;
	String name;
	int salary;
	Address address;
	
	public Employee2() {
		
	}
	
	public Employee2(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
//	injection of address bean in employee bean via constructor
	public Employee2(Address address) {
		this.address = address;
	}
	
//	following interface methods should be defined that control the bean life cycle.
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Employee2 Bean created using interface");
		
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Employee2 Bean destroyed using interface");
		
	}

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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	

	public Address getAddress() {
		return address;
	}
	
	
//	injection of address bean in employee via setter method
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}

}
