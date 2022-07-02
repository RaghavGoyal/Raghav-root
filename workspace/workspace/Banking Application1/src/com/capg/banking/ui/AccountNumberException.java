package com.capg.banking.ui;

public class AccountNumberException extends Exception {
	
public AccountNumberException(){
		
	}
	
	public String toString(){
	     return ("ERROR: Account no should be 10 digit") ;
	}

}
