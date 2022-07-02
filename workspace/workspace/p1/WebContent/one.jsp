<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.util.*" %>
<%
  Scanner sc=new Scanner(System.in);
  String x=sc.nextLine();

String uname=request.getParameter("t1");
System.out.println("Upper part "+uname);
String pwd=request.getParameter("t2");
System.out.println(uname);
System.out.println("Input= "+x+"Test Failed "+uname);
if(x.equals(uname))
{
	System.out.println("True");
}
else
	System.out.println("False");

%>
</body>
</html>