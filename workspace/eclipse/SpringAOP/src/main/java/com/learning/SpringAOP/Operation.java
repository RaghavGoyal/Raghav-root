package com.learning.SpringAOP;


// This class represents the class that contains actual business logic of the application.
// For example, this class contains three methods, which contains business logic.

public class Operation {
	
	public void msg(){
		System.out.println("msg method invoked");
	}
	
    public int m(){
    	System.out.println("m method invoked");
    	return 2;
	}
    
    public int k(){
    	System.out.println("k method invoked");
    	return 3;
	}
    
    public void validateAge(int age) {
    	if(age < 18)
    		throw new ArithmeticException("Invalid age");
    	else
    		System.out.println("Valid age for voting...");
    	
    }

}
