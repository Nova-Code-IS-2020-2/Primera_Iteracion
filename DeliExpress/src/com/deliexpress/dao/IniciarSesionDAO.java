package com.deliexpress.dao;

import java.sql.*;    
import java.util.List;   
import javax.sql.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.deliexpress.model.Cliente;
import com.deliexpress.model.Repartidor;
import com.deliexpress.model.Administrador;
import com.deliexpress.model.Cuenta;


public class IniciarSesionDAO {
	
	
	public Cliente checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
			String jdbcURL = "jdbc:mysql://localhost:3306/deli_express";
			String dbUser = "root";
			String dbPassword = "";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			String sql = "select * from cliente where email = ? && contr = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			Cliente cliente = null;
			
			if (result.next()) {
			    cliente = new Cliente();
			    cliente.setEmail(email);
			}
			
			connection.close();
			System.out.println("CHECKLOGIN");
			return cliente;
		}
	public Repartidor checkLoginRepartidor(String email, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/deli_express";
		String dbUser = "root";
		String dbPassword = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "select * from repartidor where email = ? && contr = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		
		Repartidor repartidor = null;
		
		if (result.next()) {
		    repartidor = new Repartidor();
		    repartidor.setEmail(email);
		}
		
		connection.close();
		System.out.println("CHECKLOGIN REPARTIDOR");
		return repartidor;
	}
	public Administrador checkLoginAdmin(String email, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/deli_express";
		String dbUser = "root";
		String dbPassword = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "select * from administrador where email = ? && contr = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		
		Administrador admin = null;
		
		if (result.next()) {
		    admin = new Administrador();
		    admin.setEmail(email);
		}
		
		connection.close();
		System.out.println("CHECKLOGIN ADMIN");
		return admin;
	}
}
