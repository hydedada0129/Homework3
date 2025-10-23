package vo;

public class ShoppingReportView {
	//porder_id, customer_name, product_name, qty, shipping_address, total
	private String porder_id;
	private String customer_name;
	private String product_name;
	private int qty;
	private String shipping_address;
	private int total;
	
	public ShoppingReportView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingReportView(String porder_id, String customer_name, String product_name, int qty,
			String shipping_address, int total) {
		super();
		this.porder_id = porder_id;
		this.customer_name = customer_name;
		this.product_name = product_name;
		this.qty = qty;
		this.shipping_address = shipping_address;
		this.total = total;
	}
	
//	public ShoppingReportView(String porder_id, String customer_name, String product_name, int qty,
//			String shipping_address, int total) {
//		super();
//		this.porder_id = porder_id;
//		this.customer_name = customer_name;
//		this.product_name = product_name;
//		this.qty = qty;
//		this.shipping_address = shipping_address;
//		this.total = total;
//	}

	public String getPorder_id() {
		return porder_id;
	}
	public void setPorder_id(String porder_id) {
		this.porder_id = porder_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
