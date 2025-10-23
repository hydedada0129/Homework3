package po.dao;

import java.util.List;

import po.Customer;

public interface CustomerDao {
	//CRUD
	//Create
	void insert(Customer customer);
	
	//Read
	List<Customer> selectAll(Customer customer);
	boolean selectByUsername(String username);	//判斷註冊帳號是否存在
	Customer selectByUsernamePassword(String username, String password);	//判斷登入帳號
	String selectByUsernameForId(Customer customer);
	int selectById(int id);
	int selectById(Customer customer);
	String selectNewestId();	//抓最新的客戶編號: CUSTxxx
	//Update
	void update(Customer customer);
	void updateCustomerIdAndTime(String username);
	
	
	//Delete
	void delete();
	
}
