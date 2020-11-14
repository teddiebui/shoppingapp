package com.teddie.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.teddie.dao.AccountDAO;
import com.teddie.model.Account;
import com.teddie.model.Product;

public class AccountDaoImpl implements AccountDAO{
	
	private JdbcTemplate jdbcTemplateObject;
	private static final RowMapper<Account> ROW_MAPPER = (rs, rowNum) -> {
		Account account = new Account();
		account.setUsername(rs.getString("email"));
		account.setPassword(rs.getString("password"));
		account.setPhoneNumber(rs.getString("phone_number"));
		account.setAddress(rs.getString("address"));
		return account;
	};
	
	public AccountDaoImpl(JdbcTemplate obj) {
		// TODO Auto-generated constructor stub
		jdbcTemplateObject = obj;
	}
	
	public AccountDaoImpl() {}


	@Override
	public int addAccount(Account account) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `Account` (`email`, `password`, `phone_number`, `address`) "
				+ "VALUES (?, ?, ?, ?)";
		int result = jdbcTemplateObject.update(sql, 
				account.getUsername(), 
				account.getPassword(), 
				account.getPhoneNumber(),
				account.getAddress());
		return result;
	}
	
	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `Account` WHERE `email` = ?";
		Account account = jdbcTemplateObject.query(sql,
				new Object[] {username},
				rs -> rs.next() ? ROW_MAPPER.mapRow(rs, 1) : null);
		return account;
	}
	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	
	@Override
	public String toString() {
		return "AccountDaoIml [jdbcTemplateObject=" + jdbcTemplateObject + "]";
	}
	

}
