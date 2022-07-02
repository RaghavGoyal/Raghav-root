package com.capg.banking.service;

import com.capg.banking.beans.Account;

public interface AccountService {
	
	Account getAccountDetails(String accountNo);
	
	double showbalance(String accountNo);
	
	double deposite(String accountNo, double depositeAmount);
	
	double withdraw(String accountNo, double withdrawAmount);
	
	String transfer(String fromaccountNo, String toaccountNo, double transferAmount);
	
	void printtransaction(String accountNo);

}
