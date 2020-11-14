package com.teddie.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.teddie.dao.impl.ProductDaoImpl;
import com.teddie.model.Product;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class ProductDaoImplTest {
	private ProductDaoImpl productDAO;
	
	
	@BeforeEach
	void beforeEach() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl( "jdbc:mysql://firstdatabaseinstance.cqza48oiiwcv.us-east-1.rds.amazonaws.com:3306/shoppingapp?serverTimezone=UTC");
        config.setUsername( "binh_01" );
        config.setPassword( "Binh1993" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        
        HikariDataSource ds = new HikariDataSource(config);
        productDAO = new ProductDaoImpl(new JdbcTemplate(ds));
        }

	@Test
	void testListProducts() {
		List<Product> list = productDAO.listProducts("1", "6");
		for (Product product: list) {
			System.out.println(product.getID());
		}
		list = productDAO.listProducts("2", "6");
		for (Product product: list) {
			System.out.println(product.getID());
		}
//		
//		list = productDAO.listProducts("3", "6");
//		for (Product product: list) {
//			System.out.println(product.getID());
//		}
//		
//		list = productDAO.listProducts("4", "6");
//		for (Product product: list) {
//			System.out.println(product.getID());
//		}
//		
//		list = productDAO.listProducts("5", "6");
//		for (Product product: list) {
//			System.out.println(product.getID());
//		}
//		list = productDAO.listProducts("6", "6");
//		for (Product product: list) {
//			System.out.println(product.getID());
//		}
//		list = productDAO.listProducts("7", "6");
//		for (Product product: list) {
//			System.out.println(product.getID());
//		}
//		list = productDAO.listProducts("8", "6");
//		for (Product product: list) {
//			System.out.println(product.getID());
//		}
//		list = productDAO.listProducts("1", "6");
		assertTrue(!list.isEmpty());
	}

	@Test
	void testSearch() {
		List<Product> list = productDAO.search("128","all", "1", "40");
		
		System.out.println(list.size());
		
		assertTrue(!list.isEmpty());
	}

	@Test
	void testGetProduct() {
		Product product = productDAO.getProduct(1);
		System.out.println(product);
		
		product = productDAO.getProduct(1);
		System.out.println(product);
		
		product = productDAO.getProduct(1);
		System.out.println(product);
		
		product = productDAO.getProduct(2);
		System.out.println(product);
		
		product = productDAO.getProduct(40);
		System.out.println(product);
		
		product = productDAO.getProduct(41);
		System.out.println(product);

		product = productDAO.getProduct(4);
		System.out.println(product);
		assertTrue(product != null);
	}

	@Test
	void testGetSize() {
		int size = productDAO.getSize("", "all");
		System.out.println(size);
		
		size = productDAO.getSize("128", "all");
		System.out.println(size);
		
		size = productDAO.getSize("256", "all");
		System.out.println(size);
		
		size = productDAO.getSize("12313ffsdfdsfds", "all");
		System.out.println(size);
		
		size = productDAO.getSize("", "all");
		System.out.println(size);
		
		assertTrue(size != 0);
	}

}
