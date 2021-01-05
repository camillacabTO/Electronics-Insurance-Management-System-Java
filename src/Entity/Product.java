package Entity;

public class Product {
	private String productname;
	private int quantity;
	private String category;
	
	
	
	@Override
	public String toString() {
		return "Product [productname=" + productname + ", quantity=" + quantity + ", category=" + category + "]";
	}
	public Product() {
		super();
	}
	public Product(String productname, int quantity, String category) {
		super();
		this.productname = productname;
		this.quantity = quantity;
		this.category = category;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
	
}
