package po.service.impl;

import java.util.ArrayList;
import java.util.List;

import po.Product;
import po.dao.impl.ProductDaoImpl;
import po.service.ProductService;
import util.StringHandler;

public class ProductServiceImpl implements ProductService{

	public static void main(String[] args) {
//		new ProductServiceImpl().add(new Product("P010", "人工淚液","藥品", 159));
//		System.out.println(new  ProductServiceImpl().findAll().get(2).getName());
		/*
		List<Product> list=new ArrayList();
		ProductServiceImpl psi=new ProductServiceImpl();
		list=psi.findByProductname("無線滑鼠");
		for(Product obj:list) {
			System.out.println(obj.getName()+"\t"+obj.getUnit_price());
		}
		*/
		System.out.println(new ProductServiceImpl().findForProductId());
	}

	//import DaoImpl and new
	ProductDaoImpl pdi=new ProductDaoImpl();
	
	@Override
	public void add(Product product) {
		pdi.insert(product);
	}

	@Override
	public List<Product> findAll() {
		
		return pdi.selectAll();
	}
	

	@Override
	public List<Product> findById(int id) {
		
		return null;
	}
	
	@Override
	public String findForProductId() {
		String product_id=StringHandler.getNewNum(pdi.selectNewestId());
		return product_id;
	}
	
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findByProductname(String productname) {
		return pdi.selectByProductname(productname);
	}	
}
