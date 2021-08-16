package Common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLDatabase {
	
	static String dburl = "jdbc:sqlserver://db205.my-hosting-panel.com;DatabaseName=goggery_digiorder_dev_1";
	static String username = "goggery_digiorder_dev_user";
	static String password = "devuser@20";

	public static void validatecategorylistindatabase() {
					
		try {
					
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();	
			Connection conn = DriverManager.getConnection(dburl, username, password);
				
		    if(conn != null) { 
		    	Reports.INFO("SQL server is connected");
				//System.out.println("connected"); 
			}
				  
			String sql = "select * from tbl_category";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
				  
			while(result.next()) {
				System.out.println("Name: "+result.getString("c_title")+" Details: "+result.getString("c_description"));
			}
			
			Reports.PASS("List of all categories in category page are displayed in our database");
		} catch(Exception ex) {
			System.out.println("input is wrong for connecting to database");
		}
				
	}
	
}


