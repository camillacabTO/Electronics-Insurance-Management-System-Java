package DBHelper;


import java.io.InputStream;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entity.Claim;

public class QueryClaimsByUsername {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
public List<Claim> doRead(String username) throws SQLException {
		
		 conn = DBUtils.getConn();
 
		 String sql="select * from Project_Week11.Claim where username = ?";
		 ps = conn.prepareStatement(sql);
		 
		 ps.setString(1, username);
		 rs = ps.executeQuery();

		 List<Claim> list = new ArrayList<>();
		 
		 while(rs.next()) {
			 String claimid = rs.getInt("claimid")+"";
			 String purchaseid = rs.getInt("purchaseid")+"";
			 Claim claim = new Claim(claimid, purchaseid, rs.getString("username"), rs.getString("dateofclaim"),rs.getString("description"), rs.getString("status"));
			 list.add(claim);
		 }
		return list;
		
	}
}

