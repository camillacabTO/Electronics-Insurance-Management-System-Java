package DBHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class DBUtils {
	public static Connection conn = null;	 
	public static PreparedStatement ps = null;
	public static ResultSet  rs = null;
	

	public    static Connection getConn() {
		
		InputStream is= DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
//		System.out.println("is :" + is);
		Properties prop = new Properties();
		
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String driver = prop.getProperty("driver.name");			
		String url = prop.getProperty("server.name");
		String user = prop.getProperty("user.name");
		String password = prop.getProperty("user.password");
			
		try {
			Class.forName(driver);
//				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("conn: " + conn);
	return conn;
		
	}
	
 

}
