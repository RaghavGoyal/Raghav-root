package com.cg.mra.ui;

public class MobileNumberException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public MobileNumberException(){
		
	}
	
	public String toString(){
	     return ("ERROR: Mobile no should be 10 digits") ;
	}

}
