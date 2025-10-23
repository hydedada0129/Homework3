package po.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import po.Product;
import po.dao.ProductDao;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao{

	public static void main(String[] args) {
		
		//test insert:
//		new ProductDaoImpl().insert(new Product("P009", "魚肝油", "藥品", 1000));
		
		//test: selectAll
		/*
		List<Product> list=new ArrayList();
		ProductDaoImpl pdi=new ProductDaoImpl();
		list = pdi.selectAll();
		System.out.println(list.get(0).getName());
		for(Product obj:list) {
			System.out.println(obj.getName()+obj.getUnit_price());
		}*/
		/*
		List<Product> list=new ArrayList();
		ProductDaoImpl pdi=new ProductDaoImpl();
		list=pdi.selectByProductname("無線滑鼠");
		for(Product obj:list) {
			System.out.println(obj.getName()+"\t"+obj.getUnit_price());
		}
		*/
		//System.out.println(new ProductDaoImpl().selectNewestId());
	}

	//自己寫的連線class
	Connection conn=DbConnection.getDb();
	
	@Override
	public void insert(Product product) {
		String sql="insert into product(product_id, name, type, price) values(?,?,?,?)";
		try {
			
			//連線語法物件
			PreparedStatement ps=conn.prepareStatement(sql);
			//sql ?: 值
			ps.setString(1, product.getProduct_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getType());
			ps.setInt(4, product.getUnit_price());
			//執行
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String selectNewestId() {
		String sql="select product_id from product order by product_id desc limit 1";
		String Productid="";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Productid=rs.getString("product_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return Productid;
	}
	
	@Override
	public List<Product> selectAll() {
		String sql="select * from product";
		List<Product> list=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {	//讀取抓取出來的data
				Product product=new Product();
				product.setProduct_id(rs.getString("product_id"));
				product.setName(rs.getString("name"));
				product.setType(rs.getString("type"));
				product.setUnit_price(rs.getInt("unit_price"));
				list.add(product);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

	
	@Override
	public List<Product> selectById(int id) {
		
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> selectByProductname(String productname) {
		String sql="select * from product where name=?";
		List<Product> list =new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, productname);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product product=new Product();
				product.setProduct_id(rs.getString("product_id"));
				product.setName(rs.getString("name"));
				product.setType(rs.getString("type"));
				product.setUnit_price(rs.getInt("unit_price"));
				list.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
