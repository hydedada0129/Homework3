package vo.dao;

import java.util.List;

import vo.Join3Tables;

public interface Join3TablesDao {
	//read
	List<Join3Tables> selectAll();
	List<Join3Tables> selectByCustomerName(String customerName);
	List<Join3Tables> selectByProductName(String productName);
	
	
}
