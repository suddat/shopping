package com.sDev.shoppingBackend.dao;

import java.util.List;

import com.sDev.shoppingBackend.dto.Product;

public interface ProductDAO {
	// return true if successfully added or false if not
	List<Product> list();

	Product get(int id);

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);
	
	//services
	
	List<Product> listActiveProducts();
	
	List<Product> listActiveProductsByCategory(int categoryId);
	
	List<Product> getLatestActiveProducts(int count);
}
