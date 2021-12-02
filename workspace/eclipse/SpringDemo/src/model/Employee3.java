package model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// This bean is similar to Employee or Employee2;
// The only difference is in how bean life-cycle is controlled.

// Here the life cycle is controlled using annotation rather than being controlled through XML or interface  

public class Employee3 {
	
	int id;
	String name;
	int salary;
	Address address;
	
	public Employee3() {
		
	}
	
	public Employee3(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
//	injection of address bean in employee bean via constructor
	public Employee3(Address address) {
		this.address = address;
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("Employee3 Bean initialised using annotation...");
	}
	
	@PreDestroy
	public void myDest() {
		System.out.println("Employee3 Bean destroyed using annotation...");
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
