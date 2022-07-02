package com.capg.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DepositMoney {

	public void depositMoney(int accNo, String pass)
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
				System.out.println("Welcome "+rs.getString(2)+"!!!");
				System.out.println("Current Balance: Rs. "+rs.getInt(1));
				System.out.print("Enter amount to deposit: Rs. ");
				int amount = sc.nextInt();
				int balance = rs.getInt(1)+amount;
				sql = "UPDATE moneybank SET balance="+balance+" WHERE accNo="+accNo;
				int i = stmt.executeUpdate(sql);
				if(i==1)
				{
					System.out.println("Money successfully deposited!!");
					System.out.println("New Balance: Rs. "+balance+"\n");
				}
				else
					System.out.println("Failed to deposit money!! Please try later");
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
