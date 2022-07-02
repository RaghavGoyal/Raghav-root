

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
     * Default constructor. 
     */
    public Hello() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter outt=response.getWriter();
		
		try
		{
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("1");
			 String s1=request.getParameter("t1");
			 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			 System.out.println("2");
			 
			String s2=request.getParameter("t2");
			String s3=request.getParameter("t3");
			String s4=request.getParameter("t4");
			 
			 System.out.println("3");
			 int a= 0;
			 PreparedStatement ps=con.prepareStatement("INSERT INTO 'capg'.'student' ('RollNo', 'Name') VALUES ('?','?')");
			 System.out.println("4");
			 ps.setInt(1,Integer.parseInt(s4));
			 ps.setString(2,s1);
		     a=ps.executeUpdate();
			 System.out.println("values moved to database");
			 
		}
		catch(Exception e)
		{
		}
		
		
		
		
	
	
	}
}

