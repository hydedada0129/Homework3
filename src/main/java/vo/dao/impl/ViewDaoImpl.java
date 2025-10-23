package vo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ShoppingReportView;
import vo.dao.ViewDao;
import util.DbConnection;

public class ViewDaoImpl implements ViewDao{

	public static void main(String[] args) {
		
	}
	
	Connection conn=DbConnection.getDb();
	
	@Override
	public List<ShoppingReportView> selectView() {
		String sql="select * from report_view";
		List<ShoppingReportView> list=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ShoppingReportView reportView=new ShoppingReportView();
				reportView.setPorder_id(rs.getString("porder_id"));
				reportView.setCustomer_name(rs.getString("customer_name"));
				reportView.setProduct_name(rs.getString("product_name"));
				reportView.setQty(rs.getInt("qty"));
				reportView.setShipping_address(rs.getString("shipping_address"));
				reportView.setTotal(rs.getInt("total"));
				list.add(reportView);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

		

}
