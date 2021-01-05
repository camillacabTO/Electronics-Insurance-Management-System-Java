package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBHelper.DBUtils;
import Entity.Customer;
import Entity.Purchase;

public class QueryRegisteredProductByCustomerDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
public List<Purchase> customerRegisteredProduct( String username) throws SQLException {
		
		 conn = DBUtils.getConn();
 
		 String sql="select * from purchase where username = ?";
		 ps = conn.prepareStatement(sql);
		 
		 ps.setString(1, username);
		 rs = ps.executeQuery();

		 List<Purchase> list = new ArrayList<>();
		 
		 while(rs.next()) {
			 Purchase product = new Purchase(rs.getString("purchaseid"),rs.getString("username"), rs.getString("productname"), rs.getString("serialno"),rs.getString("purchasedate"),rs.getInt("availableclaims"));
 
			 list.add(product);
		 }
		return list;
		
	}
 

}
