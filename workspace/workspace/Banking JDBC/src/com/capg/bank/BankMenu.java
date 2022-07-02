package com.capg.bank;

import java.util.Scanner;

public class BankMenu {

	public static void main(String[] args) {
		
		String password;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("******Welcome to Money Bank******");
			System.out.println("We offer the following services here:");
			System.out.println("1. Create New User");
			System.out.println("2. View Balance");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Exit");
			System.out.print("Enter ur Choice: ");
			int choice = sc.nextInt();
			int accNo;
			
			switch(choice)
			{
				case 1: //create new account
					accNo = (int) (1000000000+Math.random()*9999);
					CreateUser cu = new CreateUser();
					cu.createUser(accNo);
					break;
				case 2: //view balance
					System.out.print("Enter Account No.: ");
					accNo = sc.nextInt();
					System.out.print("Enter Password: ");
					password = sc.next();
					ViewBalance vb = new ViewBalance();
					vb.viewBalance(accNo, password);
					break;
				case 3: //deposit money
					System.out.print("Enter Account No.: ");
					accNo = sc.nextInt();
					System.out.print("Enter Password: ");
					password = sc.next();
					DepositMoney dm = new DepositMoney();
					dm.depositMoney(accNo, password);
					break;
				case 4: //withdraw money
					System.out.print("Enter Account No.: ");
					accNo = sc.nextInt();
					System.out.print("Enter Password: ");
					password = sc.next();
					WithdrawMoney wm = new WithdrawMoney();
					wm.withdrawMoney(accNo, password);
					break;
				case 5: //fund transfer
					System.out.print("Enter Account No.: ");
					accNo = sc.nextInt();
					System.out.print("Enter Password: ");
					password = sc.next();
					FundTransfer ft = new FundTransfer();
					ft.fundTransfer(accNo, password);
					break;
				case 6: //exit application
					sc.close();
					System.out.println("Exiting Application!!!");
					System.exit(0);
					break;
			}
		}
	}

}
