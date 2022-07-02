package p_main;

import java.sql.Connection;
import java.sql.DriverManager;

import p_insert.Insert;
import p_update.Update;


public class Main {
	public static void main(String args[])
	{
		System.out.println("1");
		String name="raghav_new";
		String RollNo="8556";
		System.out.println(name);
		System.out.println(RollNo);
		try{
		
			System.out.println("inside try in main");
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver executed");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","");
			 System.out.println("2");
			Insert in=new Insert();
			Update up=new Update();
			System.out.println("objects created successfully");
			in.insert(con,name, RollNo);
			up.update(con,name,"123");
		}
		catch(Exception e)
		{}
		
	}
}
