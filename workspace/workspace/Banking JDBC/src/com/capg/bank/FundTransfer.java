package com.capg.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FundTransfer {

	public void fundTransfer(int accNo, String pass)
	{
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capg", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT balance,name FROM moneybank WHERE accNo="+accNo+" AND password='"+pass+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				int balance = rs.getInt(1);
				System.out.println("Welcome "+rs.getString(2)+"!!!");
				rs.close();
				System.out.println("Current Balance: Rs. "+balance);
				System.out.print("Enter Account No. to which money to be transferred: ");
				int accNo1 = sc.nextInt();
				if(accNo!=accNo1)
				{
					sql = "SELECT name,balance FROM moneybank WHERE accNo="+accNo1;
					rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						String name = rs.getString(1);
						int balance1 = rs.getInt(2);
						rs.close();
						System.out.print("Enter amount to Transfer to "+name+": Rs. ");
						int amount = sc.nextInt();
						if(balance<amount)
						{
							System.out.println("Insufficient money in account!!");
							con.close();
							return;
						}
						balance -= amount;
						sql = "UPDATE moneybank SET balance="+balance+" WHERE accNo="+accNo;
						int i = stmt.executeUpdate(sql);
						balance1 += amount;
						sql = "UPDATE moneybank SET balance="+balance1+" WHERE accNo="+accNo1;
						int j = stmt.executeUpdate(sql);
						if(i==1 && j==1)
						{
							System.out.println("Money successfully debited and transfered!!");
							System.out.println("New Balance: Rs. "+balance+"\n");
						}
						else
							System.out.println("Failed to transfer money!!");
					}
					else
					{
						System.out.println("Account No. not found!!");
						System.out.println("Transfer Failed!!\n");
					}
				}
				else
					System.out.println("Please dont enter ur account no. \nTransfer Failed!!\n");
			}
			else
				System.out.println("Please enter correct details!!\n");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
