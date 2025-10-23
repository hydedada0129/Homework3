package vo.service.impl;

import java.util.ArrayList;
import java.util.List;

import vo.ShoppingReportView;
import vo.dao.impl.ViewDaoImpl;
import vo.service.ViewService;

public class ViewServiceImpl implements ViewService{

	public static void main(String[] args) {
		/*
		List<ShoppingReportView> list=new ArrayList(); 
		ShoppingReportView view=new ShoppingReportView();
		list=new ViewServiceImpl().findtView();
		for(ShoppingReportView obj: list) {
			System.out.println(
					obj.getCustomer_name()+" "+
					obj.getPorder_id()+" "+
					obj.getCustomer_name()+ " "+
					obj.getProduct_name()+" "+
					obj.getCustomer_name()+" "+
					obj.getQty()+" "+
					obj.getShipping_address()+ " "+
					obj.getTotal());
		}
		*/
		
	}
	ViewDaoImpl vdi=new ViewDaoImpl();
	@Override
	public List<ShoppingReportView> findtView() {
		

		//return vdi.selectView();
		return vdi.selectView();
	}
//	@Override
//	public List<ShoppingReportView> findQtyHistory() {
//		
//		return null;
//	}

}
