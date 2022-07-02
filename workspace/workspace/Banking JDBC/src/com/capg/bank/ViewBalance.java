package com.capg.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewBalance {

	public void viewBalance(int accNo, String pass)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capg", "root", "");
			Statement stmt = con.createStatement();
			String sql = "SELECT balance FROM moneybank WHERE accNo="+accNo+" AND password='"+pass+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				System.out.println("Balance: Rs. "+rs.getInt(1)+"\n");
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
