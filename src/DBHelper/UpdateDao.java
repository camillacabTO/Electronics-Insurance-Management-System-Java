package DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Customer;
import Entity.Product;
import Entity.Purchase;

public class UpdateDao {
	
	
	//Delete User Dao;
	public boolean deleteUserDao(String username) {
		
		PreparedStatement ps = null;
 
		int count =-1;
				
		String sql ="delete from user where username=?";
		try {
			ps = DBUtils.getConn().prepareStatement(sql);
			ps.setString(1, username);
			
			count = ps.executeUpdate();
 		
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		
		if(count > 0) {

			System.out.println("Delete User successfully");
			return true;
		}else {

			System.out.println("Delete User failed");
			return false;
		}
	}

	//delete registered product Dao
	public boolean deleteRegisteredProductDao(String username,String productname) {
		
		PreparedStatement ps = null;
 
		int count =-1;
				
		String sql ="delete from purchase where username=? and productname=?";
		try {
			ps = DBUtils.getConn().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, productname);
			
			count = ps.executeUpdate();
 			
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		
		if(count > 0) {
			System.out.println("Delete RegisteredProduct successfully");
			return true;
		}else {
			System.out.println("Delete RegisteredProduct failed");
			return false;
		}
	}
	
	
	//delete Inventory product Dao
		public boolean deleteInventoryProductDao(String productname) {
			
			PreparedStatement ps = null;
	 
			int count =-1;
					
			String sql ="delete from product where  productname=?";
			try {
				ps = DBUtils.getConn().prepareStatement(sql);
				 
				ps.setString(1, productname);
				
				count = ps.executeUpdate();
	 			
				System.out.println("delete inventory product rows : " + count);
			} catch (SQLException e) {
	 			e.printStackTrace();
			}
			
			if(count > 0) {
				System.out.println("Delete  InventoryProduct successfully");
				return true;
			}else {
				System.out.println("delete InventoryProduct failed");
				return false;
			}
		}
		
		
		//Update Customer Dao
		public boolean UpdateCustomerDao(String username, Customer customer) {
			
			PreparedStatement ps = null;
	 
			int count =-1;
					
			String sql ="update user set password = ?,cellphoneno = ?,email = ? ,name = ? ,address = ? where username=?  ";
			try {
				ps = DBUtils.getConn().prepareStatement(sql);
				ps.setString(1, customer.getPassword());
				ps.setString(2, customer.getCellphoneno());
				ps.setString(3, customer.getEmail());
				ps.setString(4, customer.getName());
				ps.setString(5, customer.getAddress());
				ps.setString(6, username);
				
				count = ps.executeUpdate();
	 			
			} catch (SQLException e) {
	 			e.printStackTrace();
			}
			
			if(count > 0) {
				System.out.println("update user  successfully");
				return true;
			}else {
				System.out.println("update user  failed");
				return false;
			}
		}
		
		//Update Purchase Dao
		public boolean UpdateRegisteredProductDao(String purchaseid, Purchase purchase ) {
			
			PreparedStatement ps = null;
	 
			int count =-1;
					
			String sql ="update purchase set username =?, productname = ?, serialno =?,  purchasedate =?  ,availableclaims =? where  purchaseid=?";
			try {
				ps = DBUtils.getConn().prepareStatement(sql);
				ps.setString(1, purchase.getUsername());
				ps.setString(2, purchase.getProductname());
				ps.setString(3, purchase.getSerialno());
				ps.setString(4, purchase.getPurchasedate());
				ps.setInt(5, purchase.getAvailableclaims());
				ps.setString(6, purchaseid);
				
				
				count = ps.executeUpdate();
	 			
			} catch (SQLException e) {
	 			e.printStackTrace();
			}
			
			if(count > 0) {
				System.out.println("update purchase successfully");
				return true;
			}else {
				System.out.println("update purchase failed");
				return false;
			}
		}
		
		
	//Update Inventory product Dao
	public boolean UpdateInventoryProductDao( String productname , Product product) {
		
		PreparedStatement ps = null;
 
		int count =-1;
				
		String sql ="update product set category = ?, quantity = ? where productname=?";
		try {
			ps = DBUtils.getConn().prepareStatement(sql);
			ps.setString(1, product.getCategory());
			ps.setInt(2, product.getQuantity());
			ps.setString(3, productname);
 
			
			count = ps.executeUpdate();
 			
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		
		if(count > 0) {
			System.out.println("Update product successfully");
			return true;
		}else {
			System.out.println("Update product failed");
			return false;
		}
	}
	

	//Update Claim Status Dao
		public boolean UpdateClaimStatusDao( int claimid) {
			
			PreparedStatement ps = null;
	 
			int count =-1;
					
			String sql ="update claim set status = 'approved'  where claimid=?";
			try {
				ps = DBUtils.getConn().prepareStatement(sql);
				 
				ps.setInt(1, claimid);
		
				count = ps.executeUpdate();
	 			
			} catch (SQLException e) {
	 			e.printStackTrace();
			}
			
			if(count > 0) {
				System.out.println("Update claim status successfully");
				return true;
			}else {
				System.out.println("Update claim status failed");
				return false;
			}
		}
		
		
		
		//add Inventory product Dao
				public boolean addInventoryProductDao(Product product) {
					
					PreparedStatement ps = null;
			 
					int count =-1;
							
					String sql ="insert into product values(?,?,?)";
					try {
						ps = DBUtils.getConn().prepareStatement(sql);
						 
						ps.setString(1, product.getProductname() );
						ps.setInt(3, product.getQuantity());
						ps.setString(2, product.getCategory());
						
						count = ps.executeUpdate();
			 			
						System.out.println("add inventory product rows : " + count);
					} catch (SQLException e) {
			 			e.printStackTrace();
					}
					
					if(count > 0) {
						System.out.println("addd  InventoryProduct successfully");
						return true;
					}else {
						System.out.println("add InventoryProduct failed");
						return false;
					}
				}
				
}
