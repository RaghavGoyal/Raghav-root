package com.cg.mra.ui;

public class MobileNumberNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public MobileNumberNotFoundException(){
		
	}
	
	public String toString(){
	     return ("ERROR: Given Account Id Does Not Exists") ;
	  }
}
