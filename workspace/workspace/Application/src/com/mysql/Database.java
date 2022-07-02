package com.mysql;

import java.sql.DriverManager;
import java.sql.*;

public class Database {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("DB");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","");
System.out.println("Con");
		}
		catch(Exception e){}
	}

}
