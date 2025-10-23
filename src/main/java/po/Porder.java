package po;

public class Porder {
	private int id;
	private String porder_id;	//產生後再 update
	private String customerid;	//insert
	private String status;		//default
	private String payment_method;	//default credit card
	private String shipping_address;	//UI
	private int total;	//order_items的sub相加
	public Porder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Porder(String porder_id, String customerid, String shipping_address, int total) {
		super();
		this.porder_id = porder_id;
		this.customerid = customerid;
		this.status = status;
		this.payment_method = payment_method;
		this.shipping_address = shipping_address;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPorder_id() {
		return porder_id;
	}
	public void setPorder_id(String porder_id) {
		this.porder_id = porder_id;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
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
