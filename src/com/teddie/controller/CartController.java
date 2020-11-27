package com.teddie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.teddie.dao.impl.ProductDaoImpl;
import com.teddie.model.Cart;
import com.teddie.model.Product;

@SessionAttributes("cart")
@Controller
public class CartController {
	@Autowired
	private ProductDaoImpl productDAO;
	
	@GetMapping("/cart")
	public ModelAndView cart(ModelAndView model) {
		model.setViewName("cart");
		return model;
	}
	@GetMapping("/cart/add/{id}")
	public ModelAndView cartAddItem(ModelAndView model,
			Cart cart,
			@PathVariable("id") String ID) {
		Product product = productDAO.getProduct(Integer.parseInt(ID));
		cart.add(product);
		model.setViewName("cart");
		return model;
	}
	
	@GetMapping("/cart/remove/{id}")
	public ModelAndView cartRemoveItem(ModelAndView model,
			Cart cart,
			@PathVariable("id") String ID) {
		cart.remove(Integer.parseInt(ID));
		System.out.println("cart before remove: " + cart);
		System.out.println("cart after remove: " + cart);
		model.setViewName("cart");
		return model;
	}
	
	@GetMapping("/cart/remove/{id}/decrement")
	public ModelAndView cartItemDecrement(ModelAndView model,
			Cart cart,
			@PathVariable("id") String ID) {
		model.setViewName("forward:/cart/remove/"+ID);
		return model;
	}
	
	@GetMapping("/cart/add/{id}/increment")
	public ModelAndView cartItemIncrement(ModelAndView model,
			Cart cart,
			@PathVariable("id") String ID) {
		model.setViewName("forward:/cart/add/"+ID);
		return model;
	}
	

}
