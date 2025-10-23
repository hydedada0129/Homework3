package vo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbConnection;
import vo.Join3Tables;
import vo.dao.Join3TablesDao;

public class Join3TablesDaoImpl implements Join3TablesDao{

	public static void main(String[] args) {
		/*
		List<Join3Tables> list = new ArrayList();
		list=new Join3TablesDaoImpl().selectAll();
		for(Join3Tables obj:list) {
//			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername());
			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername()+
					"\t"+obj.getEmployeename()+"\t"+obj.getProductname()+
					"\t"+obj.getOrderitemsqty()+"\t"+obj.getTotal());
		}*/
		
		/*
		List<Join3Tables> list = new ArrayList();
		list=new Join3TablesDaoImpl().selectByCustomerName("史密斯珍妮");
		for(Join3Tables obj:list) {

			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername()+
					"\t"+obj.getEmployeename()+"\t"+obj.getProductname()+
					"\t"+obj.getOrderitemsqty()+"\t"+obj.getTotal());
		}
		*/
		List<Join3Tables> list = new ArrayList();
		list=new Join3TablesDaoImpl().selectByProductName("無線滑鼠");
		for(Join3Tables obj:list) {

			System.out.println(obj.getPorder_id()+"\t"+obj.getCustomername()+
					"\t"+obj.getEmployeename()+"\t"+obj.getProductname()+
					"\t"+obj.getOrderitemsqty()+"\t"+obj.getTotal());
		}
	}

	Connection conn=DbConnection.getDb();
	
	@Override
	public List<Join3Tables> selectAll() {
		String sql="select * from order_view";
		List<Join3Tables> list = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Join3Tables join=new Join3Tables();
				join.setPorder_id(rs.getString("porder_id"));
				join.setCustomername(rs.getString("customername"));
				join.setEmployeename(rs.getString("employeename"));
				join.setProductname(rs.getString("productname"));
				join.setOrderitemsqty(rs.getInt("orderitemsqty"));
				join.setTotal(rs.getInt("total"));
				list.add(join);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	@Override
	public List<Join3Tables> selectByCustomerName(String customerName) {
		String sql="select * from order_view where customername=?";
		List<Join3Tables> list = new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, customerName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Join3Tables j=new Join3Tables();
				j.setPorder_id(rs.getString("porder_id"));
				j.setCustomername(rs.getString("customername"));
				j.setEmployeename(rs.getString("employeename"));
				j.setProductname(rs.getString("productname"));
				j.setOrderitemsqty(rs.getInt("orderitemsqty"));
				j.setTotal(rs.getInt("total"));
				list.add(j);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Join3Tables> selectByProductName(String productName) {
		String sql="select * from order_view where productname=?";
		List<Join3Tables> list = new ArrayList();
 		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, productName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Join3Tables j=new Join3Tables();
				j.setPorder_id(rs.getString("porder_id"));
				j.setCustomername(rs.getString("customername"));
				j.setEmployeename(rs.getString("employeename"));
				j.setProductname(rs.getString("productname"));
				j.setOrderitemsqty(rs.getInt("orderitemsqty"));
				j.setTotal(rs.getInt("total"));
				list.add(j);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
