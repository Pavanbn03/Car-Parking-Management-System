import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.GregorianCalendar;


public class demo {
	public static void main(String[] args) {
		try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          String url = "jdbc:mysql://localhost:3306/sql?autoReconnet=true&useSSL=false";
	          String uname = "root";
	          String pass = "";
	          Connection co = DriverManager.getConnection(url, uname, pass);
	          Statement st = co.createStatement();
	          String query ="Select * from demo;";
	          ResultSet rs=st.executeQuery(query);
	          while(rs.next()) {
	        	  Integer id=rs.getInt("id");
	        	  String name=rs.getString("name");
	        	  System.out.println(+id+"   "+name);
	        	Calendar cal = new GregorianCalendar();
	        	System.out.println(cal.getTime());
	        	 
	          } rs.close();
	        	  st.close();
	        	  co.close();
}catch(Exception e) {
	System.out.println(e);
	}
		
}
}