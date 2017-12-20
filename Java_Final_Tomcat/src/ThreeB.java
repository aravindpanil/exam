

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ThreeB")
public class ThreeB extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter obj = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("val");
		String init = initials(name);
		obj.println("Your initials are "+init);
	}
	
	public String initials(String n){
		char c;
		int i;
		String ini=""+n.charAt(0);
		for(i = 0;i<n.length();i++){
			c = n.charAt(i);
			
			if(c == ' '){
				ini = ini+n.charAt(i+1);
			}
		}
		return ini;
	}

}
