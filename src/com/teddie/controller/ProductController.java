package com.teddie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teddie.dao.impl.ProductDaoImpl;


@Controller
public class ProductController {
	@Autowired
	private ProductDaoImpl productDAO;
	
	@GetMapping("/list")
	public ModelAndView list(ModelAndView model,
			@RequestParam("maxItemDisplay") String maxItemDisplay,
			@RequestParam("pageNumber") String pageNumber) {
		model.setViewName("list");
		model.addObject("products", productDAO.listProducts(pageNumber, maxItemDisplay));
		model.addObject("totalProducts", productDAO.getSize());
		return model;
		
	}

}
