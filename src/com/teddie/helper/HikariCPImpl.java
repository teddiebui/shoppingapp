package com.teddie.helper;

import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPImpl extends HikariDataSource{
	private HikariConfig config;
	private HikariDataSource ds;
	
	public HikariCPImpl() {
		config = new HikariConfig();
		
		config.setJdbcUrl( "jdbc:mysql://firstdatabaseinstance.cqza48oiiwcv.us-east-1.rds.amazonaws.com:3306"
				+ "/shoppingapp?serverTimezone=UTC");
        config.setUsername( "binh_01" );
        config.setPassword( "Binh1993" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds = new HikariDataSource(config);
	}
	
	public HikariDataSource getDataSource() {
		return ds;
	}
	
}
