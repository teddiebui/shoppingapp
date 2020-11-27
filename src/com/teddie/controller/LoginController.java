package com.teddie.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teddie.dao.impl.AccountDaoImpl;
import com.teddie.model.Account;

@Controller
public class LoginController {
	@Autowired
	private AccountDaoImpl accountDAO;
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView model,
			HttpServletRequest request,
			RedirectAttributes attributes,
			@ModelAttribute Account account,
			@RequestParam(value="current_url", required = false) String prev_url) {
		
		//handle login form
		model.setViewName("redirect:/" + (prev_url == null ? "index" : getBaseUrl(prev_url)));
		Account exist = accountDAO.getAccount(account.getUsername());
		
		if (exist != null) {
			if (exist.getPassword().equalsIgnoreCase(account.getPassword())) {
				//LOGIN SUCCESSFULLY
				HttpSession session = request.getSession();
				session.setAttribute("account", exist);
				return model;
			}
			//WRONG USERNAME OR PASSWORD
			attributes.addAttribute("action","login");
			attributes.addFlashAttribute("error","Email or password is incorrect");
			return model;
			
		}
		//ACCOUNT DOESN'T EXIST
		attributes.addAttribute("action","login");
		attributes.addFlashAttribute("error","Email doesn't exist");
		return model;
		
	} 
	
	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.setViewName("index");
		return model;
	}
	
	private String getBaseUrl(String url) {
		Pattern pattern = Pattern.compile("/(\\w+)[.]jsp");
		Matcher matcher = pattern.matcher(url);
		
		String baseUrl = "";
		if (matcher.find()) {
			baseUrl += matcher.group(1);
		}
		
		return baseUrl;
	}

}
