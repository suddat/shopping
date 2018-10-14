package com.sDev.shopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sDev.shopping.exception.ProductNotFoundException;
import com.sDev.shoppingBackend.dao.CategoryDAO;
import com.sDev.shoppingBackend.dao.ProductDAO;
import com.sDev.shoppingBackend.dto.Category;
import com.sDev.shoppingBackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		logger.info("Inside pageController index method - INFO");
		logger.info("Inside pageController index method - DEBUG");

		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView viewAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView viewCategoryProducts(@PathVariable("id") int id) {
		Category category = null;

		category = categoryDAO.get(id);

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing a single category
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	/*
	 * Single Page Product View
	 */
	@RequestMapping(value = { "/show/{id}/product" })
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

		Product product = productDAO.get(id);

		if (product == null)
			throw new ProductNotFoundException("Product With Id " + id + " not available currently");

		product.setViews(product.getViews() + 1);
		productDAO.update(product);

		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);

		return mv;
	}

}
