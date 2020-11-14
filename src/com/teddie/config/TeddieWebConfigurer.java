package com.teddie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.teddie.dao.impl.AccountDaoImpl;
import com.teddie.dao.impl.ProductDaoImpl;
import com.teddie.helper.HikariCPImpl;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.teddie")
public class TeddieWebConfigurer implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/media/");
		
	}
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public ProductDaoImpl productDAO(JdbcTemplate jdbcTemplateObject) {
		return new ProductDaoImpl(jdbcTemplateObject);
	}
	
	@Bean
	public AccountDaoImpl accountDAO(JdbcTemplate jdbcTemplateObject) {
		return new AccountDaoImpl(jdbcTemplateObject);
	}
	@Bean
	public JdbcTemplate jdbcTemplateObject() {
		HikariCPImpl hikariCP = new HikariCPImpl();
        return new JdbcTemplate(hikariCP.getDataSource());
	}

}
