package Entity;

public class Purchase {
	private String purchaseid; // Added ID field, to be feed when we retrieve the records from the DB
	private String username;
	private String productname;
	private String serialno;
	private String purchasedate;
	private int availableclaims;
	
	public String getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	@Override
	public String toString() {
		return "Purchase [purchaseid=" + purchaseid + ", username=" + username + ", productname=" + productname
				+ ", serialno=" + serialno + ", purchasedate=" + purchasedate + "]";
	}
	public Purchase(String purchaseid, String username, String productname, String serialno, String purchasedate) {
		super();
		this.purchaseid = purchaseid;
		this.username = username;
		this.productname = productname;
		this.serialno = serialno;
		this.purchasedate = purchasedate;
	}
	
	
	public Purchase(String purchaseid, String username, String productname, String serialno, String purchasedate,
			int availableclaims) {
		super();
		this.purchaseid = purchaseid;
		this.username = username;
		this.productname = productname;
		this.serialno = serialno;
		this.purchasedate = purchasedate;
		this.availableclaims = availableclaims;
	}
	public Purchase() {
		super();
	}
	public int getAvailableclaims() {
		return availableclaims;
	}
	public void setAvailableclaims(int availableclaims) {
		this.availableclaims = availableclaims;
	}
	 
	
}
