package com.capg.banking.ui;

import java.util.Scanner;

import com.capg.banking.beans.Account;
import com.capg.banking.service.AccountServiceImpl;

public class MainUI {

	final static String WELCOME_MESSAGE = "Welcome to Money Bank Customer Care Sevices. Enter your choice of operation:";
	final static String ACCOUNT_BALANCE_ENQUIRY = "1 for getting Account Details and Balance Enquiry";
	
	final static String ACCOUNT_BALANCE = "Your Current Balance is Rs. ";
	final static String ACCOUNT_Depsite = "2 to Deposite Amount";
	final static String ACCOUNT_Withdraw = "3 to Withdraw Amount";
	final static String ACCOUNT_Transfer = "4 to Transfer Amount";
	
	final static String EXIT = "5 to Exit";
	final static String WRONG_INPUT = "Not a vaid Input. Try again.";
	
	public static void main(String args[])
	{
		
        Scanner sc = new Scanner(System.in);
		
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
		
		while(true)
		{
			
			System.out.println(WELCOME_MESSAGE);
			System.out.println(ACCOUNT_BALANCE_ENQUIRY);
			System.out.println(ACCOUNT_Depsite);
			System.out.println(ACCOUNT_Withdraw);
			System.out.println(ACCOUNT_Transfer);
			System.out.println(EXIT);
			
			int choice = sc.nextInt();
			
			switch(choice){
			case 1 : {
				System.out.println("Enter Account Number: ");
				String accountNo = sc.next();
				try{
					if(accountNo.length()!=10) throw new AccountNumberException();
					
					Account account = accountServiceImpl.getAccountDetails(accountNo);
					if(!account.equals(null))
						System.out.println(ACCOUNT_BALANCE + account.getAccountBalance());
				}
				catch(AccountNumberException e){
					System.out.println(e.toString());
				}
				catch(NullPointerException e){
				}
			}
			break;
			case 2 : {
				System.out.println("Enter Account Number: ");
				String accountNo = sc.next();
				try{
					if(accountNo.length()!=10) throw new AccountNumberException();
					
					System.out.println("Enter Deposite Amount: ");
					double amount = sc.nextDouble();
					
					if(amount<0) throw new NegativeAmountException();
					
					double updatedBalance = accountServiceImpl.deposite(accountNo,amount);
					
					Account account = accountServiceImpl.getAccountDetails(accountNo);
					
					System.out.println("Your Amount Deposited Successfully");
					
					System.out.println("Hello "+account.getCustomerName()+", Available Balance is Rs. "+updatedBalance);
				}
				catch(AccountNumberException e){
					System.out.println(e.toString());
				}
				catch(NegativeAmountException e){
					System.out.println(e.toString());
				}
				catch(NullPointerException e){
				}
			}
			break;
			case 3 : {
				
				System.out.println("Enter Account Number: ");
				String accountNo = sc.next();
				try{
					if(accountNo.length()!=10) throw new AccountNumberException();
					
					System.out.println("Enter Withdraw Amount: ");
					double amount = sc.nextDouble();
					
					if(amount<0) throw new NegativeAmountException();
					
					double updatedBalance = accountServiceImpl.withdraw(accountNo,amount);
					
					Account account = accountServiceImpl.getAccountDetails(accountNo);
					
					System.out.println("Your Amount Withdraw is Successful.");
					
					System.out.println("Hello "+account.getCustomerName()+", Available Balance is Rs. "+updatedBalance);
				}
				catch(AccountNumberException e){
					System.out.println(e.toString());
				}
				catch(NegativeAmountException e){
					System.out.println(e.toString());
				}
				catch(NullPointerException e){
				}
			}
			break;
				
			
			case 4:
			{
				System.out.println("Enter Your Account Number: ");
				String fromaccountNo = sc.next();
				System.out.println("Enter Account Number to Transfer money: ");
				String toaccountNo = sc.next();
				try{
					if(fromaccountNo.length()!=10||toaccountNo.length()!=10) throw new AccountNumberException();
					
					System.out.println("Enter transfer Amount: ");
					double amount = sc.nextDouble();
					
					if(amount<0) throw new NegativeAmountException();
					
					String result = accountServiceImpl.transfer(fromaccountNo,toaccountNo,amount);
					System.out.println(result);
	
					Account account = accountServiceImpl.getAccountDetails(fromaccountNo);
					if(!account.equals(null))
						System.out.println("Available Balance" + account.getAccountBalance());
					//System.out.println("Hello "+account.getCustomerName()+", Available Balance is Rs. "+updatedBalance);
				}
				catch(AccountNumberException e){
					System.out.println(e.toString());
				}
				catch(NegativeAmountException e){
					System.out.println(e.toString());
				}
				catch(NullPointerException e){
				}
			}
			break;
			
			
			case 5:
			{
				System.out.println("Application Exit");
				System.exit(0);
			}
			
			default: {
				System.out.println(WRONG_INPUT);
			}
			}
			
		}
		
	}
}
