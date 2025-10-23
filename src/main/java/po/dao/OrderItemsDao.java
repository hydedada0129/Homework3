package po.dao;

import java.sql.PreparedStatement;


public interface OrderItemsDao {
	void insert(String oi_id, String o_id, int qty, String pr_id, int subtotal, int u_price);
	
//	void update(String order_item_id, int id);
	String selectNewestOiId();
}
