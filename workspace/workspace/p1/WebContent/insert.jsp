<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import ="java.sql.*" %>
<%@page import ="java.util.*" %>
<% 
System.out.println("Enter the id");
Scanner sc=new Scanner(System.in);
int a=sc.nextInt();
%>

<%
   try{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/capg","root","root");
	   String s1=request.getParameter("t1");
	   String s2=request.getParameter("t2");
	   String s3=request.getParameter("t3");
	   
	   System.out.println(s1+" "+s2);
	   
	   Statement stm=con.createStatement();
	   String sql="INSERT INTO 'capg'.'stu' ('uname')VALUES('+s1')";
	   
	   stm.executeUpdate(sql);
	   
   }
catch(Exception e)
{
	
}
%>

</body>
</html>