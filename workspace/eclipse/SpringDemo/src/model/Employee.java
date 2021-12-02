package model;

// POJO or Model or Bean
public class Employee {
	
	int id;
	String name;
	int salary;
	Address address;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
//	injection of address bean in employee bean via constructor
	public Employee(Address address) {
		this.address = address;
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

	public void myInit() {
		System.out.println("Employee Bean initialised using XML...");
	}
	
	public void myDest() {
		System.out.println("Employee Bean Destroyed using XML...");
	}

}
