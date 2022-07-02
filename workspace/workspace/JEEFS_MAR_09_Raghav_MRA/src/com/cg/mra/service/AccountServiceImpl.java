package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.ui.MobileNumberNotFoundException;

public class AccountServiceImpl implements AccountService{
	
	@Override
	public Account getAccountDetails(String mobileNo) {
		
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(accountDaoImpl.accountEntry.containsKey(mobileNo)){
				return accountDaoImpl.getAccountDetails(mobileNo);
			}
			else throw new MobileNumberNotFoundException();
		}
		catch(MobileNumberNotFoundException e){
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {
		
		try{
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			if(!accountDaoImpl.accountEntry.containsKey(mobileNo))
				throw new MobileNumberNotFoundException();
			return accountDaoImpl.rechargeAccount(mobileNo,rechargeAmount);
		}
		catch(MobileNumberNotFoundException e){
			System.out.println("ERROR: Caanot Recharge Account as Given Mobile Number Does Not Exists");
		}
		return 0.0;
		
	}
	
	
	

}
