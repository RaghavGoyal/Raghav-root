

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("1");
			 String s1=request.getParameter("t1");
			 System.out.println(s1);
			 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			 System.out.println("2");
			 
			 String s2=request.getParameter("t2");
			 String s3=request.getParameter("t3");
			 String s4=request.getParameter("t4");
			 
			 int i=0;
			 Statement stm=con.createStatement();
			 String qury="INSERT INTO `capg`.`student` (`RollNo`, `Name`) VALUES ('"+s4+"', '"+s1+"')";
			 i=stm.executeUpdate(qury);
			 
		}
		catch(Exception e)
		{
		}
		
		
		
		PrintWriter outt=response.getWriter();
		outt.print("<html> <body> <h3>hello from servlet</h3>  </body> </html> ");
	
	
	}
	
	

}
