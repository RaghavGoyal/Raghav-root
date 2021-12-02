package com.learning.SpringAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This project demonstrates the Aspect oriented programming (AOP).
 * AOP compliments OOPs in the sense that it also provides modularity.
 * But the key unit of modularity is aspect than class.
 * 
 * AOP breaks the program logic into distinct parts (called concerns). 
 * It is used to increase modularity by cross-cutting concerns.
 * 
 * A cross-cutting concern is a concern that can affect the whole application and
 * should be centralized at one location in code, such as transaction management, authentication, logging, security etc.
 * 
 * More theory at https://www.javatpoint.com/spring-aop-tutorial
 */

// This class represents the driver method of the application
public class App {
	
    public static void main(String[] args) {
//        create application context:
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
    	
    	Operation op = (Operation) context.getBean("opBean");
		System.out.println("calling msg...");
	    op.msg();
	    System.out.println("calling m...");
	    op.m();
	    System.out.println("calling k...");
	    op.k();
	    
	    System.out.println("Validating age 15");
	    try{
	    	op.validateAge(15);
	    }
	    catch(ArithmeticException e) {
//	    	Absorbed the exception here so that main can  continue to execute...
	    }
	    
	    System.out.println("Validating age 20");
	    op.validateAge(20);
    	
    }
}
