package com.capg.banking.ui;

public class AccountNumberNotFoundException extends Exception {
public AccountNumberNotFoundException(){
		
	}
	
	public String toString(){
	     return ("ERROR: Given Account Number Does Not Exist") ;
	  }

}
