package DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Purchase;

public class LoginDao {
	
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	
	public boolean login(String username, String password) {

		int count = -1;
	 	
		try {
			ps = DBUtils.getConn().prepareStatement("select count(1) from  user where username=? and password=?");			
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
					
			if(rs.next()) {
				count = rs.getInt(1);
			}
		
		} catch (SQLException e) {
				 
			e.printStackTrace();
		}
		 
		if(count > 0) {
			return true;
		}else {
			return false;
		}
		 
	}

	

}
