package com.teddie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PayController {
	
	@GetMapping("/payment")
	public ModelAndView payment(ModelAndView model) {
		return model;
	}

}
