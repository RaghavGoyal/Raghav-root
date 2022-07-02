package com.capg.banking.ui;

public class NegativeAmountException extends Exception {
public NegativeAmountException(){
		
	}
	
	public String toString(){
	     return ("ERROR: Cannot Proceed Further as Give Amount is in Negative") ;
	  }
}
