package po.service.impl;

import po.dao.impl.PorderDaoImpl;
import po.service.PorderService;
import util.CustomerFileIO;
import util.StringHandler;

public class PorderServiceImpl implements PorderService{

	public static void main(String[] args) {
		PorderServiceImpl osi=new PorderServiceImpl();
		String porder_id=osi.findNextId();
		System.out.println(porder_id);
		String customerid=CustomerFileIO.readCustomerToFile().getCustomerid();
		osi.add(porder_id, customerid, "test addr", 10);
		System.out.println(porder_id);

	}

	PorderDaoImpl pdi=new PorderDaoImpl();
	
	@Override
	public void add(String porder_id, String customerid, String shipping_address, int total) {
		pdi.insert(porder_id, customerid, shipping_address, total);
	}
	@Override
	public String findNextId() {
		return StringHandler.getNewNum(pdi.selectNewestId());
	}
//	@Override
//	public void updatePorderId(String porderid, int id) {
//		pdi.update(porderid, id);
//	}

}
