package DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Claim;
import Entity.Customer;
import Entity.Product;
import Entity.Purchase;
 

public class QueryDao {
	
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	
	//get all Claims
	public List<Claim> queryAllClaims() {

		List<Claim> list = new ArrayList<>();	
	 	
		try {
			ps = DBUtils.getConn().prepareStatement("select * from  Claim");			
			rs = ps.executeQuery();
					
			while(rs.next()) {
				
				Claim claim = new Claim();
				claim.setClaimid(rs.getString("claimid"));
				claim.setPurchaseid(rs.getString("purchaseid") );
				claim.setUsername( rs.getString("username"));
				claim.setDateofclaim(rs.getString("dateofclaim"));
				claim.setDescription(rs.getString("description"));
				claim.setStatus(rs.getString("status"));
				list.add(claim);
			}
		
		} catch (SQLException e) {
				 
			e.printStackTrace();
		}
		 
		return list;
	}
	
	
	
	//get all Purchase items
	public List<Purchase> queryAllProduct() {

		List<Purchase> list = new ArrayList<>();	
	 	
		try {
			ps = DBUtils.getConn().prepareStatement("select * from  Purchase");			
			rs = ps.executeQuery();
					
			while(rs.next()) {
				
				Purchase product = new Purchase();
				product.setPurchaseid(rs.getString("purchaseid"));
				product.setUsername(rs.getString("username") );
				product.setProductname( rs.getString("productname"));
				product.setSerialno(rs.getString("serialno"));
				product.setPurchasedate(rs.getString("purchasedate"));
				product.setAvailableclaims(rs.getInt("availableclaims"));
				list.add(product);
			}
		
		} catch (SQLException e) {
				 
			e.printStackTrace();
		}
		 
		return list;
	}
	
	//get all user from database
	public List<Customer> queryAllUser() {

		List<Customer> list = new ArrayList<>();	
	 	
		try {
			ps = DBUtils.getConn().prepareStatement("select * from  User");			
			rs = ps.executeQuery();
					
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setUsername(rs.getString("username") );
				customer.setPassword( rs.getString("password"));
				customer.setCellphoneno(rs.getString("cellphoneno"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address")); 
				list.add(customer);
			}
		
		} catch (SQLException e) {
				 
			e.printStackTrace();
		}
		 
		return list;
	}
	
	
	//query all inventory product (Product table)
	public List<Product> queryInventoryProduct() {

		List<Product> list = new ArrayList<>();	
	 	
		try {
			ps = DBUtils.getConn().prepareStatement("select * from  Product");			
			rs = ps.executeQuery();
					
			while(rs.next()) {
				Product product = new Product();
				
				product.setProductname( rs.getString("productname"));
				product.setCategory( rs.getString("category"));
				product.setQuantity(rs.getInt("quantity"));
				 
				list.add(product);
			}
		
		} catch (SQLException e) {
				 
			e.printStackTrace();
		}
		 
		return list;
	}
	
	//query all inventory product by productname (Product table)
		public Product queryInventoryProductByProductname(String productname) {
			
			Product product =null;
					 	
			try {
				ps = DBUtils.getConn().prepareStatement("select * from  Product where productname = ?");
				ps.setString(1, productname);
				rs = ps.executeQuery();
						
				if(rs.next()) {
					product = new Product( rs.getString("productname"),rs.getInt("quantity"),rs.getString("category"));
			
				}
			
			} catch (SQLException e) {
					 
				e.printStackTrace();
			}
			 
			System.out.println("queryInventoryProductByProductname : " + product);
			return product;
		}
		
	
	//get all user from database
		public  Customer  queryUserByUsername(String username) {
			Customer customer = null;
			 
			try {
				ps = DBUtils.getConn().prepareStatement("select * from  User where username=?");	
				ps.setString(1, username);
				rs = ps.executeQuery();
						
				if(rs.next()) {
					customer = new Customer();
					customer.setUsername(rs.getString("username") );
					customer.setPassword( rs.getString("password"));
					customer.setCellphoneno(rs.getString("cellphoneno"));
					customer.setEmail(rs.getString("email"));
					customer.setName(rs.getString("name"));
					customer.setAddress(rs.getString("address")); 
					 
				}
			
			} catch (SQLException e) {
					 
				e.printStackTrace();
			}
			 
			return customer;
		}
		
		//get all Registered Product by Username from database
		public  List<Purchase>  queryRegisteredProduct(String username) {
			Customer customer = null;
			List<Purchase> list = null;
			
			try {
				ps = DBUtils.getConn().prepareStatement("select * from purchase where username=?");	
				ps.setString(1, username);
				rs = ps.executeQuery();
				list = new ArrayList<>();	
				while(rs.next()) {
					Purchase product = new Purchase();
					product.setPurchaseid(rs.getString("purchaseid"));
					product.setUsername(rs.getString("username") );
					product.setProductname( rs.getString("productname"));
					product.setSerialno(rs.getString("serialno"));
					product.setPurchasedate(rs.getString("purchasedate"));
					product.setAvailableclaims(rs.getInt("availableclaims"));
					list.add(product);
				}
			
			} catch (SQLException e) {
					 
				e.printStackTrace();
			}
			 
			return list;
		}
		
		public Purchase  queryPurchaseByID(String purchaseid) { // find purchase to check number of claims available 
			Purchase purchase = null;
			
			try {
				ps = DBUtils.getConn().prepareStatement("select * from purchase where purchaseid = ?");	
				ps.setString(1, purchaseid);
				rs = ps.executeQuery();
				purchase = new Purchase();
				while(rs.next()) {
					Purchase product = new Purchase();
					product.setPurchaseid(rs.getString("purchaseid"));
					product.setUsername(rs.getString("username") );
					product.setProductname( rs.getString("productname"));
					product.setSerialno(rs.getString("serialno"));
					product.setPurchasedate(rs.getString("purchasedate"));
					product.setAvailableclaims(Integer.parseInt(rs.getString("availableclaims")));
					purchase = product;
				}
			
			} catch (SQLException e) {
					 
				e.printStackTrace();
			}
			return purchase;
		}

		public void updateClaimsAvailable(String purchaseid, int claimsAvailable) { // update claims available in specific purchase after claim form is submitted
			
			try {
				ps = DBUtils.getConn().prepareStatement("UPDATE Purchase SET availableclaims = ? WHERE purchaseid = ?");
				ps.setInt(1, claimsAvailable);
				ps.setString(2, purchaseid);
				int updates = ps.executeUpdate();
				System.out.println("Claims Update executed: " + updates);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
		}
		

}
