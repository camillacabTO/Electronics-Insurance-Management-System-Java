package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBHelper.DBUtils;
import Entity.Customer;
import Entity.Product;
import Entity.Purchase;

public class RegisterProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
public int registerProduct( Purchase product) throws SQLException {
		
		 conn = DBUtils.getConn();
 
		 String sql="insert into purchase (username,productname,serialno,purchasedate) values(?,?,?,?);";
		 ps = conn.prepareStatement(sql);
		 
		 ps.setString(1, product.getUsername());
		 ps.setString(2, product.getProductname());
		 ps.setString(3, product.getSerialno());
		 ps.setString(4, product.getPurchasedate());
		  
		int count = ps.executeUpdate();
		
		return count;
		
	}

//query the database with the username customer input when registrate product
	public int queryByUsername( String username) throws SQLException {
		
		 conn = DBUtils.getConn();
		 int count = -1;
	 
		 String sql="select count(1) from user where username=?";
		 ps = conn.prepareStatement(sql);
		 
		 ps.setString(1, username);
		 
		 rs = ps.executeQuery();
		 
		 if(rs.next()) {
			 count = rs.getInt(1);
		 }
		
		return count;
		
	}
	
	//check the username is exist in the database or not
	public boolean isExistCustomer(String username) throws SQLException {
		int userCount = queryByUsername(username);
		if(userCount > 0) {
			return true;
		}else {
			return false;
		}
	}

}
