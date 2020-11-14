package com.teddie.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.teddie.dao.impl.AccountDaoImpl;
import com.teddie.model.Account;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

class AccountDaoImplTest {
	private AccountDaoImpl accountDAO;
	
	
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
        accountDAO = new AccountDaoImpl(new JdbcTemplate(ds));
        }

	@Test
	void testGetAccount() {
		Account account = accountDAO.getAccount("testset@funix.edu.vn");
		System.out.println(account);
		
		account = accountDAO.getAccount("binhbkfx02295@funix.edu.vn");
		System.out.println(account);
		assertTrue(account != null);
	}

	@Test
	void testAddAccount() {
		Account account = new Account();
		account.setAddress("xxx");
		account.setPassword("xxxxxxxx");
		account.setPhoneNumber("0123456789");
		account.setUsername("halo_1234@gmail.com");
		int result = accountDAO.addAccount(account);
		assertTrue(result > 0);
	}

	@Test
	void testUpdateAccount() {
		fail("Not yet implemented");
	}
}
