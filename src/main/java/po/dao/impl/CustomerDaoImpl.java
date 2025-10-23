package po.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import po.Customer;
import po.dao.CustomerDao;
import util.DbConnection;

public class CustomerDaoImpl implements CustomerDao {

	public static void main(String[] args) {
		/* addMember test:
		 new CustomerDaoImpl().insert(new Customer(	
				//"CUST006",        //自動產生        
			    "test4",  			
			    "test444",
			    "Bobby",                 
			    "Long Beach企業有限公司",          
			    "09445556666",           
			    "台灣台中市",             
			    "lb@example.com"));      
			    //LocalDateTime.now());	//物件產生
		*/
		
		//get username test:
		/*
		 * 	private String username;
	private String password;
	private String name;
	private String companyname;
	private String phone;
	private String address;
	private String email;
		 */
		
//		System.out.println(new CustomerDaoImpl().selectByUsernameForId(customer));
		
		/* selectByUsernamePassword test:
		 System.out.println(new CustomerDaoImpl().selectByUsernamePassword("test", "test123").getName());
		 */
		System.out.println(new CustomerDaoImpl().selectNewestId());
	}

	Connection conn=new DbConnection().getDb();
	
	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO customer(customerid, username, password, name, companyname, phone, address,email) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
		try {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1, customer.getCustomerid());		
			pstat.setString(2, customer.getUsername());
			pstat.setString(3, customer.getPassword());
			pstat.setString(4, customer.getName());
			pstat.setString(5, customer.getCompanyname());
			pstat.setString(6, customer.getPhone());
			pstat.setString(7, customer.getAddress());
			pstat.setString(8, customer.getEmail());
			pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean selectByUsername(String username) {
		String sql="select * from customer where username=?";
		boolean result=false;
		
		try {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1, username);
			ResultSet rs=pstat.executeQuery();
		
			//如果名字已經存在, return true
			if(rs.next()) 
				return result=true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String selectByUsernameForId(Customer customer) {	//建立Customer後才會有id，才能建立customerid
		String sql="select * from customer where username=?";
		String Username="";
		
		try {
			PreparedStatement pstat=conn.prepareStatement(sql);	//建立存放mysql語句物件
			pstat.setString(1, customer.getUsername());			//給予參數
			ResultSet rs=pstat.executeQuery();					//執行語句, 儲存查詢結果到ResultSet
			if(rs.next()) {										//如果有查詢結果
				Username=rs.getString("username");
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Username;
	}
	
	@Override
	public int selectById(Customer customer) {
		String sql="select * from customer where username=?";
		int Id=0;
		
		try {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1, customer.getUsername());
			ResultSet rs=pstat.executeQuery();
			if(rs.next()) {
				Id=rs.getInt("id");
				System.out.println(Id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return Id;
	}
	

	@Override
	public int selectById(int id) {
		String sql="select * from customer where id=?";
		int Id=0;
		try {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setInt(1, id);
			ResultSet rs=pstat.executeQuery();
			
			if(rs.next()) {
				Id=rs.getInt("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Id;
	}

	@Override
	public String selectNewestId() {
		String sql="select customerid from customer order by customerid desc limit 1";
		String CustomerId="";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				CustomerId=rs.getString("customerid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CustomerId;
	}

	@Override
	public void updateCustomerIdAndTime(String username)  {
		String sql_id="select * from customer where username=?";//for id value
		String sql="update customer set customerid=?, created_at=? where username=?";//for update customerId value
		String CustomerId="CUST00";
		String CustomerId_2="CUST0";
		String CustomerId_3="CUST";
		int Id=0;

		try {
			//select username
			PreparedStatement pstat_selectUsername=conn.prepareStatement(sql_id);
			pstat_selectUsername.setString(1, username);
			ResultSet rs=pstat_selectUsername.executeQuery();
			
			//update customerid & created_at
			if(rs.next()) {
//				System.out.println("get resultset");
//				System.out.println(rs.getInt("id"));
				Id=rs.getInt("id");
				LocalDateTime timeNow=LocalDateTime.now();
				
				PreparedStatement pstat_update=conn.prepareStatement(sql);
				pstat_update.setObject(2, timeNow);
				if (Id>99) {
					CustomerId_3=CustomerId_3+Id;
					System.out.println(CustomerId_3);
					//PreparedStatement pstat=conn.prepareStatement(sql);
					pstat_update.setString(1, CustomerId_3);
					pstat_update.setString(3, username);
					pstat_update.executeUpdate();
				}else if(Id>9){
					CustomerId_2=CustomerId_2+Id;
					System.out.println(CustomerId_2);
					//PreparedStatement pstat=conn.prepareStatement(sql);
					pstat_update.setString(1, CustomerId_2);
					pstat_update.setString(3, username);
					pstat_update.executeUpdate();
				}else {
					CustomerId=CustomerId+Id;
					System.out.println(CustomerId);
					//PreparedStatement pstat=conn.prepareStatement(sql);
					pstat_update.setString(1, CustomerId);
					pstat_update.setString(3, username);
					pstat_update.executeUpdate();
				}
			}
			
//			PreparedStatement pstat=conn.prepareStatement(sql);
//			pstat.setObject(2, timeNow);

//			if(Id>17) {
//				throw new OverCustomerIdRange("客戶註冊數量超過14, 需要從後端更新範圍！");
//			if (Id>99) {
//				CustomerId_3=CustomerId_3+Id;
//				System.out.println(CustomerId_3);
//				//PreparedStatement pstat=conn.prepareStatement(sql);
//				pstat.setString(1, CustomerId_3);
//				pstat.setString(3, username);
//				pstat.executeUpdate();
//			}else if(Id>9){
//				CustomerId_2=CustomerId_2+Id;
//				System.out.println(CustomerId_2);
//				//PreparedStatement pstat=conn.prepareStatement(sql);
//				pstat.setString(1, CustomerId_2);
//				pstat.setString(3, username);
//				pstat.executeUpdate();
//			}else {
//				CustomerId=CustomerId+Id;
//				System.out.println(CustomerId);
//				//PreparedStatement pstat=conn.prepareStatement(sql);
//				pstat.setString(1, CustomerId);
//				pstat.setString(3, username);
//				pstat.executeUpdate();
//			}

//			PreparedStatement pstat=conn.prepareStatement(sql);
//			pstat.setString(1, CustomerId);
//			pstat.setString(2, username);
//			pstat.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		}catch(OverCustomerIdRange e) {
//			e.printStackTrace();
//		}

	}
	
	@Override
	public Customer selectByUsernamePassword(String username, String password) {
		String sql="select * from customer where username=? and password=?";
		Customer customer=null;	//如果沒有使用者 回傳null
		try {
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1, username);
			pstat.setString(2, password);
			ResultSet rs=pstat.executeQuery();
			
			//登入確認有這個使用者 存入file讓後續頁面操作使用
			if(rs.next()) {
				customer=new Customer();
				customer.setId(rs.getInt("id"));
				customer.setCustomerid(rs.getString("customerid"));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
				customer.setName(rs.getString("name"));
				customer.setCompanyname(rs.getString("companyname"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				//LocalTimeDate is a generic Object, needs to be converted to LocalDateTime object
				//System.out.println(rs.getObject("created_at"));//2025-01-05T09:30:15-->compiler still sees it is an generic Object
//				customer.setCreated_at(rs.getObject("created_at", LocalDateTime.class));
				//System.out.println(rs.getObject("created_at", LocalDateTime.class));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customer;
	}
	
	
	@Override
	public List<Customer> selectAll(Customer customer) {
		return null;
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
