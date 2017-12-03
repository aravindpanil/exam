import java.io.*; 
import java.util.*; 
import javax.servlet.*; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/**
 * Servlet implementation class HelloServlet
 */
//Annotating servlet using @WebServlet annotation
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet { 
 
  public void doGet(HttpServletRequest req,  HttpServletResponse res)  
  throws ServletException, IOException { 
 
    // Get print writer. 
    PrintWriter out = res.getWriter(); 
    res.setContentType("text/html"); 
	out.println("<html><body>"
	           +"<h1>Hello Welcome To Servlet Programming...."
			   +"</body></html>");
  }
// Servlet to handle post method
  public void doPost(HttpServletRequest req,  HttpServletResponse res)  
  throws ServletException, IOException {
	  doGet(req,res);
  }
}
