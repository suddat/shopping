package com.sDev.shoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sDev.shoppingBackend.dao.CategoryDAO;
import com.sDev.shoppingBackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sDev.shoppingBackend");
		//context.scan("com.sDev.shoppingBackend.daoimpl");
		context.refresh();
		//categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		categoryDAO = context.getBean("categoryDAO", CategoryDAO.class);
		System.out.println(categoryDAO);
	}

	/*@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Laptops");
		category.setDescription("Latest laptops");
		category.setImageUrl("cat1.png");
		System.out.println(category.toString());
		assertEquals("Successfully added category in table", true, categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(1);
		System.out.println(category.toString());
		assertEquals("Successfully retrieved category from table", "Television", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		category.setName("TV");
		System.out.println(category.toString());
		assertEquals("Successfully updated category from table",true, categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDelete() {
		category = categoryDAO.get(2);
		assertEquals("Successfully deleted category from table",true, categoryDAO.delete(category));
	}*/
	/*@Test
	public void testCategoryList() {
		assertEquals("Successfully retrieved category List from table",2, categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDOperations() {
		//add category
		category = new Category();

		category.setName("Laptops");
		category.setDescription("Latest laptops");
		category.setImageUrl("cat1.png");
		System.out.println(category.toString());
		assertEquals("Successfully added category in table", true, categoryDAO.add(category));
		//add category
		category = new Category();

		category.setName("Television");
		category.setDescription("Latest Television");
		category.setImageUrl("cat2.png");
		System.out.println(category.toString());
		assertEquals("Successfully added category in table", true, categoryDAO.add(category));
		
		//get category
		category = categoryDAO.get(1);
		System.out.println(category.toString());
		assertEquals("Successfully retrieved category from table", "TV", category.getName());
		
		//update category
		category = categoryDAO.get(4);
		category.setName("TV");
		System.out.println(category.toString());
		assertEquals("Successfully updated category from table",true, categoryDAO.update(category));
		
		//delete category
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted category from table",true, categoryDAO.delete(category));
		
		//fetch the list
		assertEquals("Successfully retrieved category List from table",15, categoryDAO.list().size());
	}
}
