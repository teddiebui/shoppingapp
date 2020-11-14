package com.teddie.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.teddie.dao.ProductDAO;
import com.teddie.model.Product;

public class ProductDaoImpl implements ProductDAO {
	
	private static final RowMapper<Product> ROW_MAPPER = new RowMapper<Product>() {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Product product = new Product();
			
			product.setID(rs.getInt("ID"));
			product.setName(rs.getString("Name"));
			product.setDescription(rs.getString("Description"));
			product.setPrice(rs.getDouble("Price"));
			product.setSrc(rs.getString("src"));
			product.setType(rs.getString("type"));
			product.setBrand(rs.getString("brand"));	
			
			return product;
		}
	};
	private JdbcTemplate jdbcTemplateObject;
	
	
	public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public ProductDaoImpl(JdbcTemplate obj) {
		// TODO Auto-generated constructor stub
		jdbcTemplateObject = obj;
	}
	
	@Override
	public List<Product> listProducts(String pageNumber, String maxDisplays) {
		// TODO Auto-generated method stub
		return search("", "all", pageNumber, maxDisplays);
	}

	@Override
	public List<Product> search(String keyword, String category, String pageNumber, String maxDisplays) {
		// TODO Auto-generated method stub
		category = category.equalsIgnoreCase("all") ? "" : category;
		int start = (Integer.parseInt(pageNumber)-1)*6;
		String sql = "SELECT * FROM `Product` WHERE `Name` LIKE ? AND Type LIKE ? LIMIT ?, ?";
		List<Product> list = jdbcTemplateObject.query(sql,
				new Object[] {"%"+keyword +"%", "%"+category +"%", start, Integer.parseInt(maxDisplays)},
				ROW_MAPPER);
		return list;
	}

	@Override
	public Product getProduct(int ID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `Product` WHERE `ID` = ?";
		Product product = jdbcTemplateObject.query(sql,
				new Object[] {ID},
				rs -> rs.next() ? ROW_MAPPER.mapRow(rs, 1) : null);
				
		return product;
	}

	@Override
	public int getSize(String keyword, String category) {
		// TODO Auto-generated method stub
		category = category.equalsIgnoreCase("all") ? "" : category;
		String sql = "SELECT COUNT(*) FROM `Product` WHERE `Name` LIKE ? AND Type LIKE ?";
		int size = jdbcTemplateObject.queryForObject(sql,
				new Object[] {"%"+keyword+"%", "%"+category+"%"},
				Integer.class);
		return size;
	}
	
	public int getSize() {
		return getSize("", "all");
	}
	
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	@Override
	public String toString() {
		return "ProductDaoIml [jdbcTemplateObject=" + jdbcTemplateObject + "]";
	}
	
	

}
