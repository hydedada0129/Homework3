package po.service;

public interface PorderService {
	void add(String porder_id, String customerid, String shipping_address, int total);
	
//	void updatePorderId(String porderid, int id);
	String findNextId();	//抓最新的客戶編號: CUSTxxx

}
