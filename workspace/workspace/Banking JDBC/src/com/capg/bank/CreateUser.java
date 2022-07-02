package com.capg.bank;

import java.sql.*;
import java.util.Scanner;

public class CreateUser {

	public int createUser(int accNo)
	{
		String name, mobile, password;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capg", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT accNo FROM moneybank WHERE accNo="+accNo;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				accNo = (int) (1000000000+Math.random()*9999);
			}
			System.out.print("Enter Name: ");
			name = sc.next();
			System.out.print("Enter Mobile No.: ");
			mobile = sc.next();
			System.out.print("Enter Password: ");
			password = sc.next();
			sql = "INSERT INTO moneybank VALUES("+accNo+", '"+name+"', '"+mobile+"', '"+password+"', 0)";
			int i = stmt.executeUpdate(sql);
			if(i==1)
			{
				System.out.println("Welcome "+name+"!!!");
				System.out.println("Account Successfully Created!! Please note down your Account No.");
				System.out.println("Your Account No.: "+accNo);
				System.out.println("Initial Amount is Rs. 0. You can later add money to it.\n");
				con.close();
				return 1;
			}
			else
			{
				System.out.println("Account Not Created!! Please try again");
				con.close();
				return 0;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
}
