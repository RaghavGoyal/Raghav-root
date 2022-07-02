
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Database {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("1");
		
		
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			java.sql.Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/capg","root","root");
			
			String sql="INSERT INTO'capg'.'student'('RollNo','Name') VALUES('4',RAMESH')";
			int i=0;
			Statement stmt=con.createStatement();
			i=stmt.executeUpdate(sql);
			if(i==0)
				System.out.println("Registeration fail");
			else
				System.out.println("Registeration Successful");
			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		}
		catch(Exception e)
		{
			
		}
		
		

	}

}

