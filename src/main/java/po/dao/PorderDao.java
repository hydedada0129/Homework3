package po.dao;

import po.Porder;

public interface PorderDao {
	void insert(String porder_id, String customerid, String shipping_address, int total);
	
//	void update(String porderid, int id);
//	String selectByPorderId(String poderId);
	String selectNewestId();	//抓最新的客戶編號

}
