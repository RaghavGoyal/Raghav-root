<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*"%>
<%
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
String s1=request.getParameter("t1");
String s2=request.getParameter("t2");

Statement stm=con.createStatement();
String getPwd="SELECT RollNo FROM `capg`.`student`WHERE Name=";
if(getPwd==s2)
{
	System.out.println("login succesful");
	response.sendRedirect("UserPage.html");
}
else
{
	System.out.println("Login attempt failed. try again");
	response.sendRedirect("LoginPage.html");
}
}
catch(Exception e)
{
}
%>
</body>
</html>