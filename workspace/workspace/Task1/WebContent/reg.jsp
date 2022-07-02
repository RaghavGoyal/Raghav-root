<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="p_insert.Insert" %>
<%@page import="p_update.Update" %>
</head>
<body>
<%
System.out.println("1");
String s1=request.getParameter("t1");
String s2=request.getParameter("t2");
String s3=request.getParameter("t3");
String s4=request.getParameter("t4");
try{

	System.out.println("inside try in main");
	 Class.forName("com.mysql.jdbc.Driver");
	 System.out.println("driver executed");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","");
	 System.out.println("2");
	Insert in=new Insert();
	Update up=new Update();
	System.out.println("objects created successfully");
	in.insert(con,s1,s4);
	up.update(con,s1,"123");
}
catch(Exception e)
{}
%>
</body>
</html>