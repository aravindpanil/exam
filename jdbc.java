import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException,
      IOException {
	  response.setContentType("text/html;charset=UTF-8"); 
	    PrintWriter out = response.getWriter(); 
	    
	     String url = "jdbc:mysql://localhost:3306/"; 
	    String dbName = "mydb"; 
	    String driver = "com.mysql.jdbc.Driver"; 
	    String user = "root";  
	    String password = ""; 
	    Statement pstmt;
	    
	    try { 
	        Class.forName(driver).newInstance(); 
	        Connection conn = DriverManager.getConnection(url+dbName, user, password); 
	   //     PreparedStatement pstmt; 
	        String sql = "SELECT * FROM stud"; 
	        pstmt = conn.createStatement(); 
	        ResultSet rs=pstmt.executeQuery(sql); 
	        out.println("<html>"); 
            out.println("<p>MYSQL Connection is successful</p> " ); 
            String f1,f2;
            	        
	        while(rs.next()) 
	        {
	            f1 = rs.getString(1);
				f2=rs.getString(2);
				System.out.println(f1+"  "+f2);
				 out.println("<p>Welcome</p> " + f1+f2);
	            out.println("</body>"); 
	            out.println("</html>"); 
	 
	           
	        } 
	        out.close(); 
	        out.println("</body>"); 
            out.println("</html>"); 
	 
	    } catch (Exception e) { 
	    	System.out.println("ERROR"+e);
	        
	 
	        out.close(); 

}
  }
}
