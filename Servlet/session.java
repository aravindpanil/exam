import java.io.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet ("/SessionInfo ")
public class SessionInfo extends HttpServlet{


	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(true);


		pw.println("<h1>Welcome to a new Session</h1>");
		pw.println("<p>Session ID: "+session.getId()+"</p>");
		pw.println("<p>Creation Time for this Session: "+ new Date(session.getCreationTime())+"</p>");
	    	pw.println("<p>Last Access Time for this Session: "+ new Date(session.getLastAccessedTime())+"</p>");


		pw.close();
	}
}
