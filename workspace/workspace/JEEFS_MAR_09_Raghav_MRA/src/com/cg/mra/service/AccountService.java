package com.cg.mra.service;

import com.cg.mra.beans.Account;

public interface AccountService {
	Account getAccountDetails(String mobileNo);
	double rechargeAccount(String mobileNo, double rechargeAmmount);
	
	

}
