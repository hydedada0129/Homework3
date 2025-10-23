package po.service.impl;

import po.dao.impl.OrderItemsDaoImpl;
import po.service.OrderItemsService;
import util.StringHandler;

public class OrderItemsServiceImpl implements OrderItemsService{

	public static void main(String[] args) {
//		new OrderItemsServiceImpl().add("","ORD031", 2, "product_id", 998,  499);
	}
	OrderItemsDaoImpl oidi=new OrderItemsDaoImpl();
	@Override
	public void add(String oi_id, String o_id, int qty, String pr_id, int subtotal, int u_price) {
		oidi.insert(oi_id, o_id, qty, pr_id, subtotal, u_price);
	}
//	@Override
//	public void update(String order_item_id, int id) {
//		oidi.update(order_item_id, id);
//	}
	@Override
	public String findNewestOiId() {
		
		return StringHandler.getNewNum(oidi.selectNewestOiId());
	}

}
