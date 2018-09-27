package com.sDev.shoppingBackend.dao;

import java.util.List;

import com.sDev.shoppingBackend.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);
}
