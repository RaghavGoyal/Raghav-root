package com.capg.banking.dao;
import com.capg.banking.beans.Account;

	public interface AccountDao {
		Account getAccountDetails(String accountNo);
		
		double showbalance(String accountNo);
		
		double deposite(String accountNo, double depositeAmount);
		
		double withdraw(String accountNo, double withdrawAmount);
		
		String transfer(String fromaccountNo, String toaccountNo, double transferAmount);
		
		void printtransaction(String accountNo);
		
		
		

	}
