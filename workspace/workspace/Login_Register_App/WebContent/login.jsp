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
	 String s2=request.getParameter("t2");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","");
	 System.out.println("2");

	 
	 Statement stmt=con.createStatement();
	 String getPwd="SELECT RollNo FROM `capg`.`student`WHERE Name='"+s1+"'";
	 System.out.print("Success to select");
	ResultSet rs=stmt.executeQuery(getPwd);
int x=0;
	while (rs.next())
	{
		
	 
	 if(s1.equals(rs.getString(2)) && s2.equals(rs.getInt(1)))
	 {
		 //x=1;
		 response.sendRedirect("UserPage.html");
	 }
	}
	/*
	if(x==1)
	{
	 	System.out.println("login succesful");
	 	response.sendRedirect("UserPage.html");
	 }
	 else
	 {
	 	System.out.println("Login attempt failed. try again");
	 	response.sendRedirect("login.html");
	 }
*/	 
}

catch(Exception e)
{
}
%>

</body>
</html>