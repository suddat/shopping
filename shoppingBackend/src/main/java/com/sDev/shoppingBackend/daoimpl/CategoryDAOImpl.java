package com.sDev.shoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sDev.shoppingBackend.dao.CategoryDAO;
import com.sDev.shoppingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	/*private static List<Category> categories = new ArrayList<>();
	
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
	}*/
	
	@Override
	public List<Category> list() {
		String selectActiveCategory = " FROM Category WHERE active= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}
	
	/*
	 * Get Single Category based on id.
	 * */
	@Override
	public Category get(int id) {		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));		
		//return categories.get(id);
	}

	@Override	
	public boolean add(Category category) {
		try {			
			//add category code
			//System.out.println("Hereeeee" + category.toString());
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {			
			//add category code
			//System.out.println("Hereeeee" + category.toString());
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {			
			//add category code
			//System.out.println("Hereeeee" + category.toString());
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

}
