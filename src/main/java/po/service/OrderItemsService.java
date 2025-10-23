package po.service;

public interface OrderItemsService {
	void add(String oi_id,String o_id, int qty, String pr_id, int subtotal, int u_price);
	
//	void update(String order_item_id, int id);
	String findNewestOiId();

}
