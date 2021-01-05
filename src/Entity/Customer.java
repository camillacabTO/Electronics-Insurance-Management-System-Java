package Entity;

public class Customer {
	private String username;
	private String password;
	private String cellphoneno;
	private String email;
	private String name;
	private String address;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellphoneno() {
		return cellphoneno;
	}
	public void setCellphoneno(String cellphoneno) {
		this.cellphoneno = cellphoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(String username, String password, String cellphoneno, String email, String name, String address) {
		super();
		this.username = username;
		this.password = password;
		this.cellphoneno = cellphoneno;
		this.email = email;
		this.name = name;
		this.address = address;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", cellphoneno=" + cellphoneno + ", email="
				+ email + ", name=" + name + ", address=" + address + "]";
	}
 
	
	
}
