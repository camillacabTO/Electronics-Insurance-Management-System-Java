package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBHelper.DBUtils;
import Entity.Customer;

public class AddCustomerDao {
	Connection conn = null;
	PreparedStatement ps = null;
	
public int add( Customer customer) throws SQLException {
		
		 conn = DBUtils.getConn();
//		System.out.println("AddFriendDao---conn" + conn );
		 String sql="insert into user (username,password,cellphoneno,email,name,address) values(?,?,?,?,?,?);";
		 ps = conn.prepareStatement(sql);
		 
		 ps.setString(1, customer.getUsername());
		 ps.setString(2, customer.getPassword());
		 ps.setString(3, customer.getCellphoneno());
		 ps.setString(4, customer.getEmail());
		 ps.setString(5, customer.getName());
		 ps.setString(6, customer.getAddress());
 
		 
		int count = ps.executeUpdate();
		
		return count;
		
	}

}
