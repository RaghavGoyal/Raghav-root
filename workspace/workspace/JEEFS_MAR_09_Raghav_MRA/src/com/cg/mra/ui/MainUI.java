package com.cg.mra.ui;

import java.util.Scanner;
import com.cg.mra.beans.Account;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {

	/**
	 * @param args
	 */
	//initializing strings
	final static String WELCOME_MESSAGE = "Welcome to MRA Customer Care Sevices. Enter your choice of operation:";
	final static String ACCOUNT_BALANCE_ENQUIRY = "1 for Account Balance Enquiry";
	final static String ACCOUNT_BALANCE = "Your Current Balance is Rs. ";
	final static String ACCOUNT_RECHARGE = "2 for Recharge Account";
	final static String EXIT = "3 to Exit";
	final static String WRONG_INPUT = "Not a vaid Input. Try again.";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			
			Scanner sc = new Scanner(System.in);
			AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
			
			//print choices
			while(true){
				System.out.println(WELCOME_MESSAGE);
				System.out.println(ACCOUNT_BALANCE_ENQUIRY);
				System.out.println(ACCOUNT_RECHARGE);
				System.out.println(EXIT);
				
				int choice = sc.nextInt();
				
				//logic
				switch(choice){
				case 1 : {
					System.out.println("Enter Mobile Number: ");
					String mobileNo = sc.next();
					try{
						if(mobileNo.length()!=10) throw new MobileNumberException();
						
						Account account = accountServiceImpl.getAccountDetails(mobileNo);
						if(!account.equals(null))
							System.out.println(ACCOUNT_BALANCE + account.getAccountBalance());
					}
					catch(MobileNumberException e){
						System.out.println(e.toString());
					}
					catch(NullPointerException e){
					}
				}
				break;
				case 2 : {
					System.out.println("Enter Mobile Number: ");
					String mobileNo = sc.next();
					try{
						if(mobileNo.length()!=10) throw new MobileNumberException();
						
						System.out.println("Enter Recharge Amount: ");
						double amount = sc.nextDouble();
						
						if(amount<0) throw new NegativeRechargeAmmountException();
						
						double updatedBalance = accountServiceImpl.rechargeAccount(mobileNo,amount);
						
						Account account = accountServiceImpl.getAccountDetails(mobileNo);
						
						System.out.println("Your Account Recharge Successfully");
						
						System.out.println("Hello "+account.getCustomerName()+", Available Balance is Rs. "+updatedBalance);
					}
					catch(MobileNumberException e){
						System.out.println(e.toString());
					}
					catch(NegativeRechargeAmmountException e){
						System.out.println(e.toString());
					}
					catch(NullPointerException e){
					}
				}
				break;
				case 3 : {
					System.out.println("Application Exit");
					System.exit(0);
				}
				break;
				default: {
					System.out.println(WRONG_INPUT);
				}
				}
			}

	}

}
