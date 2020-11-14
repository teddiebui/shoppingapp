package com.teddie.dao;

import com.teddie.model.Account;

public interface AccountDAO {
	
	public Account getAccount(String username);
	public int addAccount(Account account);
	public int updateAccount(Account account);

}
