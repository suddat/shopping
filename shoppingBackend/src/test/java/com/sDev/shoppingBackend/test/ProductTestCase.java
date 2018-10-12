package com.sDev.shoppingBackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sDev.shoppingBackend.dao.ProductDAO;
import com.sDev.shoppingBackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sDev.shoppingBackend");
		context.refresh();
		productDAO = context.getBean("productDAO", ProductDAO.class);
	}
	/*
	 * @Test public void testCRUDOperation() { product = new Product();
	 * product.setName("Oppo selfie s3"); product.setUnitPrice(25000);
	 * product.setBrand("Oppo");
	 * product.setDescription("Discription for Oppo Mobile Phones");
	 * product.setActive(true); product.setCategoryId(3); product.setSupplierId(3);
	 * 
	 * //testing with addition of product
	 * assertEquals("Something went wrong while adding Product", true,
	 * productDAO.add(product));
	 * 
	 * //reading and then updating the category. product = productDAO.get(2);
	 * product.setName("Samsung Galaxy s3");
	 * 
	 * assertEquals("Something went wrong while updating the record", true,
	 * productDAO.update(product));
	 * 
	 * //get list of products
	 * assertEquals("Something went wrong while accessing the product list", 6,
	 * productDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testOtherOperations() {
		// list active product
		assertEquals("something went wrong while getting active list", 6, productDAO.listActiveProducts().size());
	}

	@Test
	public void testListActiveProductByCategory() {
		assertEquals("something went wrong while getting active product categories", 4,
				productDAO.listActiveProductsByCategory(3).size());
	}

	@Test
	public void testGetLatestActiveProducts() {
		assertEquals("Something went wrong while getting latest active records", 3,
				productDAO.getLatestActiveProducts(3).size());
	}

}
