package Entity;

public class Claim {
	
	private String claimid;
	private String purchaseid;
	private String username;
	private String dateofclaim;
	private String description;
	private String status;


	
	public Claim() {
		super();
	}

	public Claim(String claimid, String purchaseid, String username, String dateofclaim, String description, String status) {
		super();
		this.claimid = claimid;
		this.purchaseid = purchaseid;
		this.dateofclaim = dateofclaim;
		this.description = description;
		this.status = status;
		this.username = username;
	}
	
	public String getClaimid() {
		return claimid;
	}
	public void setClaimid(String claimid) {
		this.claimid = claimid;
	}
	public String getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(String purchaseid) {
		this.purchaseid = purchaseid;
	}
	public String getDateofclaim() {
		return dateofclaim;
	}
	public void setDateofclaim(String dateofclaim) {
		this.dateofclaim = dateofclaim;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
