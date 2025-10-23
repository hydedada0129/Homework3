package vo.service.impl;

import java.util.ArrayList;
import java.util.List;

import vo.Join3Tables;
import vo.dao.impl.Join3TablesDaoImpl;
import vo.service.Join3TablesService;

public class Join3TablesServiceImpl implements Join3TablesService{

	public static void main(String[] args) {
		/*
	 	Join3TablesServiceImpl joinServiceImpl=new Join3TablesServiceImpl();
		List<Join3Tables> list=new ArrayList();
		list=joinServiceImpl.findAll();
		for(Join3Tables obj:list) {
			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername()+
					"\t"+obj.getEmployeename()+"\t"+obj.getProductname()+
					"\t"+obj.getOrderitemsqty()+"\t"+obj.getTotal());
		}*/
		/*
		Join3TablesServiceImpl joinServiceImpl=new Join3TablesServiceImpl();
		List<Join3Tables> list=new ArrayList();
		list=joinServiceImpl.findByCustomerName("史密斯珍妮");
		for(Join3Tables obj:list) {
			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername()+
					"\t"+obj.getEmployeename()+"\t"+obj.getProductname()+
					"\t"+obj.getOrderitemsqty()+"\t"+obj.getTotal());
		}*/
		/*
		Join3TablesServiceImpl joinServiceImpl=new Join3TablesServiceImpl();
		List<Join3Tables> list=new ArrayList();
		list=joinServiceImpl.findByProductName("無線滑鼠");
		for(Join3Tables obj:list) {
			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername()+
					"\t"+obj.getEmployeename()+"\t"+obj.getProductname()+
					"\t"+obj.getOrderitemsqty()+"\t"+obj.getTotal());
		}*/
	}

	Join3TablesDaoImpl joinDaoImpl=new Join3TablesDaoImpl();
	
	@Override
	public List<Join3Tables> findAll() {
		// TODO Auto-generated method stub
		return joinDaoImpl.selectAll();
	}

	@Override
	public List<Join3Tables> findByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		return joinDaoImpl.selectByCustomerName(customerName);
	}

	@Override
	public List<Join3Tables> findByProductName(String ProductName) {
		// TODO Auto-generated method stub
		return joinDaoImpl.selectByProductName(ProductName);
	}

}
