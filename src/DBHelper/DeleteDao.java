package DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDao {
	
	public int deleteUserDao(String userName) {
		PreparedStatement ps = null;
		int deleteCount = -1;
		
		String sql = "delete from user where username = ?";
		try {
			ps = DBUtils.getConn().prepareStatement(sql);
			ps.setString(1, userName);
			
			return deleteCount = ps.executeUpdate();
			
		} catch (SQLException e) {
 			e.printStackTrace();
 			return deleteCount;

		}
		
		
	}
	
	
	public int deletePurchaseDao(String userName, String productName) {

		
		PreparedStatement ps = null;
		int deleteCount = -1;
		
		String sql = "delete from Purchase where username = ? and productname =?";
		try {
			ps = DBUtils.getConn().prepareStatement(sql);
			ps.setString(1, userName);
			
			return deleteCount = ps.executeUpdate();
			
		} catch (SQLException e) {
 			e.printStackTrace();
 			return deleteCount;

		}
		
		
	}

}
