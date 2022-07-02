package com.capg.banking.service;

import com.capg.banking.beans.Account;
import com.capg.banking.dao.AccountDaoImpl;
import com.capg.banking.ui.AccountNumberNotFoundException;

public class AccountServiceImpl implements AccountService {

	@Override
	public Account getAccountDetails(String accountNo) {
		// TODO Auto-generated method stub
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(accountDaoImpl.accountEntry.containsKey(accountNo)){
				return accountDaoImpl.getAccountDetails(accountNo);
			}
			else throw new AccountNumberNotFoundException();
		}
		catch(AccountNumberNotFoundException e){
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public double showbalance(String accountNo) {
		// TODO Auto-generated method stub
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(!accountDaoImpl.accountEntry.containsKey(accountNo))
				throw new AccountNumberNotFoundException();
			return accountDaoImpl.showbalance(accountNo);
		}
		catch(AccountNumberNotFoundException e)
		{
			System.out.println(e);
		}
		return 0.0;
	}

	@Override
	public double deposite(String accountNo, double depositeAmount) {
		// TODO Auto-generated method stub
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(!accountDaoImpl.accountEntry.containsKey(accountNo))
				throw new AccountNumberNotFoundException();
			return accountDaoImpl.deposite(accountNo,depositeAmount);
		}
		catch(AccountNumberNotFoundException e){
			System.out.println("ERROR: Caanot Recharge Account as Given Mobile Number Does Not Exists");
		}
		return 0.0;
	}

	@Override
	public double withdraw(String accountNo, double withdrawAmount) {
		// TODO Auto-generated method stub
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(!accountDaoImpl.accountEntry.containsKey(accountNo))
				throw new AccountNumberNotFoundException();
			return accountDaoImpl.withdraw(accountNo,withdrawAmount);
		}
		catch(AccountNumberNotFoundException e){
			System.out.println("ERROR: Caanot Recharge Account as Given Mobile Number Does Not Exists");
		}
		return 0.0;
	}

	@Override
	public String transfer(String fromaccountNo, String toaccountNo,
			double transferAmount) {
		// TODO Auto-generated method stub
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(!accountDaoImpl.accountEntry.containsKey(fromaccountNo)||!accountDaoImpl.accountEntry.containsKey(toaccountNo))
				throw new AccountNumberNotFoundException();
			return accountDaoImpl.transfer(fromaccountNo,toaccountNo,transferAmount);
		}
		catch(AccountNumberNotFoundException e){
			System.out.println("ERROR: Caanot Recharge Account as Given Mobile Number Does Not Exists");
		}
		return null;
	}

	@Override
	public void printtransaction(String accountNo) {
		// TODO Auto-generated method stub
		
	}
	

}
