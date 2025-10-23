package po.service;


import po.Customer;

public interface CustomerService {
	//add
	int addCustomer(Customer customer);
	
	
	//find
	//find username
	boolean findByUsername(String username);
	Customer login(String username, String password);
	void saveCustomer(Customer customer);
	String findByUsernameForId(Customer customer);
	int findById(Customer customer);
	int findById(int id);
	String findNextId();	//抓最新的客戶編號: CUSTxxx
	//update
	void updateForCustomerIdAndTime(String username);
	//delete



}