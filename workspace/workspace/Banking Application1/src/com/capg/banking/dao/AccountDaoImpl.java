package com.capg.banking.dao;
import java.util.HashMap;
import java.util.Map;
import com.capg.banking.beans.Account;


public class AccountDaoImpl implements AccountDao {
	
public Map<String, Account> accountEntry;
	
	public AccountDaoImpl() {
		accountEntry = new HashMap<>();
		accountEntry.put("8000101000", new Account("savings","Vaishali",20000.00));
		accountEntry.put("8000101001", new Account("current","Megha",45300.00));
		accountEntry.put("8000101002", new Account("current","Vikas",63145.00));
		accountEntry.put("8000101003", new Account("saving","Anju",521545.00));
		accountEntry.put("8000101004", new Account("saving","Tushar",6323.00));

}

	@Override
	public Account getAccountDetails(String accountNo) {
		// TODO Auto-generated method stub
		return accountEntry.get(accountNo);
	}

	@Override
	public double showbalance(String accountNo) {
		// TODO Auto-generated method stub
		double balance=accountEntry.get(accountNo).getAccountBalance();
		return balance;
		
		
	}

	@Override
	public double deposite(String accountNo, double depositeAmount) {
		// TODO Auto-generated method stub
		double currentBalance = accountEntry.get(accountNo).getAccountBalance();
		double newBalance = currentBalance + depositeAmount;
		accountEntry.get(accountNo).setAccountBalance(newBalance);
		return newBalance;
	}

	@Override
	public double withdraw(String accountNo, double withdrawAmount) {
		// TODO Auto-generated method stub
		double currentBalance = accountEntry.get(accountNo).getAccountBalance();
		double newBalance = currentBalance - withdrawAmount;
		accountEntry.get(accountNo).setAccountBalance(newBalance);
		return newBalance;
	}

	@Override
	public String transfer(String fromaccountNo, String toaccountNo,
			double transferAmount) {
		// TODO Auto-generated method stub
		double currentBalance1 = accountEntry.get(fromaccountNo).getAccountBalance();
		double currentBalance2 = accountEntry.get(toaccountNo).getAccountBalance();
		double newbalance1=currentBalance1-transferAmount;
		double newbalance2=currentBalance2+transferAmount;
		
		return("Funds transferred successfully");
		
	}

	@Override
	public void printtransaction(String accountNo) {
		// TODO Auto-generated method stub
		
	}
}