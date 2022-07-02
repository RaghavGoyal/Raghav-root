package p_insert;

import java.sql.Connection;

public class Insert {

	public void insert(Connection con,String s1, String s4) throws ClassNotFoundException{
		System.out.println("inside insert method");
		try{
			
		 java.sql.Statement stm=con.createStatement();
		 String qury="INSERT INTO `capg`.`student` (`RollNo`, `Name`) VALUES ('"+s4+"', '"+s1+"')";
		int i=0;
		i=stm.executeUpdate(qury);
		if(i==0)
		{
			System.out.println("insert operation failed");
		}
		else
			System.out.println("inserted");
		
		}
		
		catch(Exception e)
		{}
	} 
}
