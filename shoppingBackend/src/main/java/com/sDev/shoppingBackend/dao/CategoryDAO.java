package com.sDev.shoppingBackend.dao;

import java.util.List;

import com.sDev.shoppingBackend.dto.Category;

public interface CategoryDAO {
	//return true if successfully added or false if not
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	List<Category> list();
	Category get(int id);
	
}
