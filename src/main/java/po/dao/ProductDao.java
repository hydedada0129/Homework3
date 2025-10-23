package po.dao;

import java.util.List;

import po.Product;

public interface ProductDao {
	void insert(Product product);
	
	List<Product> selectAll();
	List<Product> selectById(int id);
	List<Product> selectByProductname(String productname);
	String selectNewestId();
	
	void update(Product product);
	
	void delete(int id);
}