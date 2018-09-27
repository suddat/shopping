package com.sDev.shoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sDev.shoppingBackend.dao.CategoryDAO;
import com.sDev.shoppingBackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Latest television");
		category.setImageUrl("cat1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobiles");
		category.setDescription("Latest Mobiles");
		category.setImageUrl("cat1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptops");
		category.setDescription("Latest Laptops");
		category.setImageUrl("cat1.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub		
		return categories;
	}

	@Override
	public Category get(int id) {		
		
		for (Category category : categories) {
			if (category.getId() == id) return category;
		}
		return null;
		
		//return categories.get(id);
	}
	

}
