package vo.service;

import java.util.List;

import vo.Join3Tables;

public interface Join3TablesService {
	List<Join3Tables> findAll();
	List<Join3Tables> findByCustomerName(String customerName);
	List<Join3Tables> findByProductName(String ProductName);
}
