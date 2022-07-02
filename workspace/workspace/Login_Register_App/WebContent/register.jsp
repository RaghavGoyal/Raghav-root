<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%
 try

{
	 Class.forName("com.mysql.jdbc.Driver");
	 System.out.println("Starting");
	 String s1=request.getParameter("t1");
	 //System.out.println(s1);
	 
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","");
	 System.out.println("2");
	 
	 String s2=request.getParameter("t2");
	 String s3=request.getParameter("t3");
	 String s4=request.getParameter("t4");
	 String s5=request.getParameter("t5");
	 
	 //s5="C:\\Users\\Raghav Goyal\\Desktop\\"+s5;
	// java.io.File f1=new java.io.File("C:\Users\Raghav Goyal\Desktop\"+s5);
	 
     File f1=new File("d:\\rag.jpg");
     System.out.println("Term");
	 FileInputStream fis= new FileInputStream(f1);
	 System.out.println("Terminated");
	 
	 
	 
	int i=0;
	 //PreparedStatement stm=con.prepareStatement()
	String qury="INSERT INTO student2 ('RollNo','Name','Photo') VALUES ('?','?','?')";
//String qury="INSERT INTO `capg`.`student` (`RollNo`, `Name`) VALUES (?, ?)";
	//String qury="UPDATE `capg`.`student` SET `Name`='"+s1+"' WHERE `RollNo`='"+s4+"' ";
	
	System.out.println("3");
	 PreparedStatement stmt=con.prepareStatement(qury);
	stmt.setInt(1,345/*Integer.parseInt(s4)*/);
	stmt.setString(2,"sss");
	System.out.println("Query");
	stmt.setBinaryStream(3,(InputStream)fis,(long)(f1.length()));
	
	 i=stmt.executeUpdate();	 
	 if(i==0)
	 {
		 response.sendRedirect("index.html");
	 }
	 else{
		 System.out.println("Database updated successfully");
		 response.sendRedirect("login.html");
	 }
	 
}
catch(Exception e)
{
	System.out.println(e);
}
%>

</body>
</html>