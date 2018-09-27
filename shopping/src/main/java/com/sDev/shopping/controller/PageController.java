package com.sDev.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sDev.shoppingBackend.dao.CategoryDAO;
import com.sDev.shoppingBackend.dto.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	@RequestMapping(value= {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
	}
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView viewAllProducts() {		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value= {"/show/category/{id}/products"})
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
	
	/*@RequestMapping(value= {"/test/{greeting}"})
	public ModelAndView test(@PathVariable(value="greeting", required=false) String greeting) {
		if (greeting == null) {
			greeting = "Hello world";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
}
