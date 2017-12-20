import java.sql.*;
public class OneB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/department";
		String driver = "com.mysql.jdbc.Driver";
		
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,"root","");
			Statement st = con.createStatement();
			String query = "SELECT no_of_employee FROM department WHERE name='CSE'";
			ResultSet rs = st.executeQuery(query);
			rs.next();
			System.out.println(rs.getInt("no_of_employee"));
			String query1 = "SELECT name,id FROM department WHERE year=2010";
			ResultSet rs1 = st.executeQuery(query1);
			
			while(rs1.next()){
				System.out.println(rs1.getString("name")+"   "+rs1.getInt("id"));
			}
			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
