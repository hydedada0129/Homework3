package po.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.Porder;
import po.dao.PorderDao;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {

	public static void main(String[] args) {
//		new PorderDaoImpl().insert("CUST039", "addrTest", 200);
	}
	Connection conn=DbConnection.getDb();

	@Override
	public void insert(String porder_id,String customerid, String shipping_address, int total) {
		String sql="insert into porder(porder_id,customerid, shipping_address, total) "
				+ "values(?,?,?,?)";
		boolean result=false;
		
		try {
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, porder_id);
			ps.setString(2, customerid);
			ps.setString(3, shipping_address);
			ps.setInt(4, total);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public String selectNewestId() {
		String sql="select porder_id from porder order by porder_id desc limit 1";
		String Porder_Id="";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Porder_Id=rs.getString("porder_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Porder_Id;
	}
	
//	@Override
//	public void update(String porderid, int id) {
//		String sql="update porder set porder_id=? where id=?";
//		try {
//			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setString(1, porderid);
//			ps.setInt(2, id);
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
