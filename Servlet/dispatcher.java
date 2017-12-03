index3.html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Validate">
Name:<input type="text" name="user" /><br/>
Password:<input type="password" name="pass" ><br/>
<input type="submit" value="submit">
</form>
</body>
</html>
Validate.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Validate")
public class Validate extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     try {
         String name = request.getParameter("user");
        String password = request.getParameter("pass");
        if(password.equals("msrit"))
        {
           RequestDispatcher rd = request.getRequestDispatcher("Welcome");
           rd.forward(request, response);
        }
        else
         { out.println("<font color='red'><b>You have entered incorrect password</b></font>");
         RequestDispatcher rd = request.getRequestDispatcher("index_req.html");
                rd.include(request, response); }
        }finally {            
            out.close();
        }  }}
Welcome.java
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          out.println("<h2>Welcome user</h2>");
        } finally {            
            out.close();
        }     } }
