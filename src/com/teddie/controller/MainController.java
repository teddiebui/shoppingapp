package com.teddie.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/index")
	public String index(
			HttpServletRequest request) {
		return "index";
	}
	
	@GetMapping("/include")
	public void redirect(
			HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("message", "Binh");
		try {
			request.getRequestDispatcher("include.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
