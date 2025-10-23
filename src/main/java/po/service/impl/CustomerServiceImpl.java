package po.service.impl;

import po.Customer;
import po.dao.impl.CustomerDaoImpl;
import po.service.CustomerService;
import util.CustomerFileIO;
import util.StringHandler;

public class CustomerServiceImpl implements CustomerService{

	public static void main(String[] args) {
		//new CustomerServiceImpl().login("test", "test123");
//		new CustomerServiceImpl().updateForCustomerId("");
//		new CustomerServiceImpl().addCustomer(new Customer("CUST040","test40","test4040","Hellan","Hair Salon",
//															"0944545664","屏東縣白河鄉","hs@example.com"));
//		System.out.println(new CustomerServiceImpl().findNextId());
		
	}
	
	CustomerDaoImpl cdi =new CustomerDaoImpl();
	
	@Override
	public int addCustomer(Customer customer) {
		//用帳戶名稱判斷是不是已經註冊過
		//findByUsername needs to be created
		if(cdi.selectByUsername(customer.getUsername())) {	
			return 1;
		}else {
			cdi.insert(customer);
			System.out.println("加入會員");
			return 0;
		}
			
	}//下一步：UI介面
	
	@Override
	public Customer login(String username, String password) {
		return cdi.selectByUsernamePassword(username, password);
		/*
		if(cdi.selectByUsernamePassword(username, password)!=null) {	//假如有此帳號

		
				//存入file
				//寫一個function of util
				Customer customer=cdi.selectByUsernamePassword(username, password);
				new SaveCustomerToFile().saveCustomer(customer);
			return customer;	
		}else {
			return null;
		}
		*/
		
	}
	

	@Override
	public String findByUsernameForId(Customer customer) {
		
		return cdi.selectByUsernameForId(customer);	//return String username
	}
	
	@Override
	public int findById(Customer customer) {
		
		return cdi.selectById(customer);
	}
	
	@Override
	public int findById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override
	public String findNextId() {
		
		return StringHandler.getNewNum(cdi.selectNewestId());
	}
	
	@Override
	public void saveCustomer(Customer customer) {	//File IO
		CustomerFileIO.saveCustomerToFile(customer);
	}
	
	@Override
	public boolean findByUsername(String username) {
		return cdi.selectByUsername(username);	//return true if username exists
	}

	@Override
	public void updateForCustomerIdAndTime(String username)  {
		cdi.updateCustomerIdAndTime(username);
	}

	public Customer readMemeber() {
		return CustomerFileIO.readCustomerToFile();
		
	}



}
