package po;

public class Product {
	private String product_id;
	private String name;
	private String type;
	private int unit_price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String product_id, String name,
			String type, int unit_price) {
		this.product_id = product_id;
		this.name = name;
		this.type = type;
		this.unit_price = unit_price;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}

	
}
