package p_update;

import java.sql.Connection;

public class Update {

	
	public void update(Connection con,String s1, String s4) throws ClassNotFoundException{
		try{
		 int i=0;
		 java.sql.Statement stm=con.createStatement();
		 String qury="UPDATE `capg`.`student` SET `Name`='"+s1+"' WHERE `RollNo`='"+s4+"';";
		i=stm.executeUpdate(qury);
		if(i==0)
		{
			System.out.println("update operation failed");
		}
		else
			System.out.println("updated");
		
		}
		
		catch(Exception e)
		{}
	} 
}
