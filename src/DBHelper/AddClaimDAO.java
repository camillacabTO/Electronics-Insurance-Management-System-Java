package DBHelper;


import java.io.InputStream;

import com.sun.xml.internal.fastinfoset.sax.Properties;
import java.io.IOException;
import java.sql.*;


import Entity.Claim;

public class AddClaimDAO {
	
	PreparedStatement ps = null;


    public int doAdd(String username, String purchaseid, String dateofclaim, String description) {
    	
    	int count = 0;
    	
    	try {
    		Claim claim = new Claim(null, purchaseid, username, dateofclaim, description, null);
			ps = DBUtils.getConn().prepareStatement("INSERT INTO Project_Week11.Claim (purchaseid, username, dateofclaim, description) VALUES (?,?,?,?)");
			 
			 ps.setString(1, claim.getPurchaseid());
			 ps.setString(2, claim.getUsername());
			 ps.setString(3, claim.getDateofclaim());
			 ps.setString(4, claim.getDescription());
			 
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;			
    }
}
