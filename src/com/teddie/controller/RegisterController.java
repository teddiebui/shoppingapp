package com.teddie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teddie.dao.impl.AccountDaoImpl;
import com.teddie.model.Account;

@Controller
public class RegisterController {
	@Autowired
	private AccountDaoImpl accountDAO;
	
	@GetMapping("/register")
	public ModelAndView register(ModelAndView model,
			RedirectAttributes attributes,
			Account account) {
		
		attributes.addFlashAttribute("newAccount", account);
		model.addObject("action","register");
		model.setViewName("redirect:/index");
		return model;
	}
	
	@PostMapping("/register_handler")
	public ModelAndView registerHandler(ModelAndView model,
			RedirectAttributes attributes,
			HttpServletRequest request,
			@ModelAttribute Account account) {
		
		Account existed = accountDAO.getAccount(account.getUsername());
		if (existed == null) {
			if (accountDAO.addAccount(account) > 0) {
				attributes.addFlashAttribute("account", account);
				model.setViewName("redirect:/login");
				return model;
			}
		}
		
		attributes.addFlashAttribute("error","Email is used, please try again");
		model.setViewName("redirect:/register");
		return model;
		
	}

}
