import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		int a=Integer.parseInt(request.getParameter("t1"));
		int b=Integer.parseInt(request.getParameter("t2"));
		
		int c=a+b;
		
		response.getWriter().println(c);
		
	}

}
