package com.deliexpress.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConexionDB {
	public DriverManagerDataSource conectarDB() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/deli_express");
		ds.setUsername("root");
		ds.setPassword("password");
		return ds;
	}
}
