package controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Employee;
import model.Employee2;
import model.Employee3;

public class EmployeeController {

	public static void main(String[] args) throws Exception {
		
//		conventional way of creating model/bean object:
		Employee emp = new Employee();
		
		emp.setId(1);
		emp.setName("Ryan");
		emp.setSalary(80000);
		
		System.out.println(emp);
		
//		using Inversion of control:
//		Step 1: Add jar files for Spring Core in the project.
//		Step 2: Configure java object in an XML file.
//		Step 3: Use Spring IOC container to get the objects constructed by spring
//				example: BeanFactory(Interface) or ApplicationContext(implementation of interface)
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");
		
		Employee e1 = (Employee) context.getBean("emp1");	// down casting the object returned from getBean
		Employee e2 = context.getBean("emp1", Employee.class); // get bean will down cast
		
		System.out.println("(Using XML)Employee2: "+e1);
		System.out.println("(Using XML)Employee2: "+e2);
		
		Employee2 e3 = (Employee2) context.getBean("emp2");
		Employee2 e4 = (Employee2) context.getBean("emp2");
		
		System.out.println("(Using interface)Employee2: "+e3);
		System.out.println("(Using interface)Employee2: "+e4);
		
		Employee3 e5 = (Employee3) context.getBean("emp3");
		Employee3 e6 = (Employee3) context.getBean("emp3");
		
		System.out.println("(Using Anotation)Employee2: "+e5);
		System.out.println("(Using Anotation)Employee2: "+e6);
		
//		Shutting down the application context:
//		NOTE: Closing the application context will cause all the beans to destroy.
		
		ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext) context;
		ctx.close();
			
	}
}
