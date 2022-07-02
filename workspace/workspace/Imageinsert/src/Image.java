import java.io.*;
import java.sql.*;
public class Image
{
	public static void main(String args[])
	{

try

{
	 Class.forName("com.mysql.jdbc.Driver");
	 System.out.println("Starting");
	 //String s1=request.getParameter("t1");
	 //System.out.println(s1);
	 
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","");
	 System.out.println("2");
	 
	 
	 //s5="C:\\Users\\Raghav Goyal\\Desktop\\"+s5;
	// java.io.File f1=new java.io.File("C:\Users\Raghav Goyal\Desktop\"+s5);
	 
     File f1=new File("d:\\rag.jpg");
     System.out.println("Term");
	 FileInputStream fis= new FileInputStream(f1);
	 System.out.println("Terminated");
	 
	 
	 
	int i=0;
	 //PreparedStatement stm=con.prepareStatement()
	String qury="INSERT INTO student2(name,img) VALUES (?,?)";
//String qury="INSERT INTO `capg`.`student` (`RollNo`, `Name`) VALUES (?, ?)";
	//String qury="UPDATE `capg`.`student` SET `Name`='"+s1+"' WHERE `RollNo`='"+s4+"' ";
	
	System.out.println("3");
	 PreparedStatement stmt=con.prepareStatement(qury);
	//stmt.setInt(1,345/*Integer.parseInt(s4)*/);
	stmt.setString(1,"sss");
	System.out.println("Query");
	stmt.setBinaryStream(2, fis,(int) f1.length());
	//stmt.setBinaryStream(3,fis,(long)(f1.length()));
	
	 i=stmt.executeUpdate();	 
	 if(i==0)
	 {
		 System.out.print("Success");
	 }
	 else{
		 System.out.println("Database updated successfully");
		 //response.sendRedirect("login.html");
	 }
	 
}
catch(Exception e)
{
	System.out.println(e);
}
}
}
