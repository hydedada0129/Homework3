package po.service;

import java.util.List;

import po.Product;

public interface ProductService {
	void add(Product product);
	
	List<Product> findAll();
	List<Product> findById(int id);
	List<Product> findByProductname(String productname);
	
	String findForProductId();
	void update(Product product);
	
	void delete();
}
