package com.teddie.dao;

import java.util.List;

import com.teddie.model.Product;

public interface ProductDAO {
	
	public List<Product> listProducts(String pageNumber, String maxDisplays);
	public List<Product> search(String keyword, String category, String pageNumber, String maxDisplays);
	public Product getProduct(int ID);
	
	public int getSize(String keyword, String category);

}
