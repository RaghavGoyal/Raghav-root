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
<%
 try
{
	 Class.forName("com.mysql.jdbc.Driver");
	 System.out.println("1");
	 String s1=request.getParameter("t1");
	 System.out.println(s1);
	 
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	 System.out.println("2");
	 
	 String s2=request.getParameter("t2");
	 String s3=request.getParameter("t3");
	 String s4=request.getParameter("t4");
	 
	 int i=0;
	 Statement stm=con.createStatement();
	 String qury="INSERT INTO `capg`.`student` (`RollNo`, `Name`) VALUES ('"+s4+"', '"+s1+"')";
	 i=stm.executeUpdate(qury);
	 
	 if(i==0)
	 {
		 response.sendRedirect("RegisterPage.html");
	 }
	 else{
		 System.out.println("Database updated successfully");
		 response.sendRedirect("LoginPage.html");
	 }
	 
}
catch(Exception e)
{
}
%>

</body>
</html>