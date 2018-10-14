package com.sDev.shopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultException {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Page is not constructed");
		mv.addObject("errorDiscription", "The Page you are looking for is not available now!");
		mv.addObject("title", "404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product Not Available");
		
		mv.addObject("errorDiscription", "Product Not available at the moment");
		
		mv.addObject("title", "Product Un-Available");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact Your administrator");
		
		/*only for debugging your application */
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDiscription", sw.toString());
		
		mv.addObject("title", "Product Un-Available");
		
		return mv;
	}
	
}
