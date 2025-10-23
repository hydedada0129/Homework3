package po.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.dao.OrderItemsDao;
import util.DbConnection;

public class OrderItemsDaoImpl implements OrderItemsDao{

	public static void main(String[] args) {
		
	}
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(String oi_id, String o_id, int qty, String pr_id, int subtotal, int u_price) {
		String sql="insert into order_items(order_item_id, porder_id, qty, product_id, subtotal, unit_price)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oi_id);
			ps.setString(2,o_id);
			ps.setInt(3, qty);
			ps.setString(4, pr_id);
			ps.setInt(5, subtotal);
			ps.setInt(6, u_price);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Override
//	public void update(String order_item_id, int id) {
//		String sql="update order_items set order_item_id=? where id=?";
//		try {
//			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setString(1, order_item_id);
//			ps.setInt(2, id);
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}

	@Override
	public String selectNewestOiId() {
		String sql="select order_item_id from order_items order by order_item_id desc limit 1";
		String orderItemId="";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				orderItemId=rs.getString("order_item_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderItemId;
	}
	
}
