package com.deliexpress.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;   
import javax.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private JdbcTemplate template;

	public Cliente checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
			String jdbcURL = "jdbc:mysql://localhost:3306/deliexpress";
			String dbUser = "root";
			String dbPassword = "deliPollo04";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			String sql = "select * from Cliente where email = ? && contr = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			Cliente cliente = null;
		
			if (result.next()) {
			    cliente = new Cliente();
			    cliente.setId_cliente(result.getInt("id_cliente"));
			    cliente.setNombre(result.getString("nombre"));
			    cliente.setAp_mat(result.getString("ap_mat"));
			    cliente.setAp_pat(result.getString("ap_pat"));
			    cliente.setTelefono(result.getString("telefono"));
			    cliente.setDireccion(result.getString("direccion"));
			    cliente.setEmail(result.getString("email"));
			    cliente.setContr(result.getString("contr"));
			}
			
			connection.close();
			System.out.println("CHECKLOGIN CLIENTE");
			System.out.println(cliente.getNombre());
			return cliente;
	}
		
	public Repartidor checkLoginRepartidor(String email, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/deliexpress";
		String dbUser = "root";
		String dbPassword = "deliPollo04";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "select * from Repartidor where email = ? && contr = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		
		Repartidor repartidor = null;
		
		if (result.next()) {
		    repartidor = new Repartidor();
		    repartidor.setId_repartidor(result.getInt("id_repartidor"));
		    repartidor.setNombre(result.getString("nombre"));
		    repartidor.setAp_mat(result.getString("ap_mat"));
		    repartidor.setAp_pat(result.getString("ap_pat"));
		    repartidor.setEmail(result.getString("email"));
		    repartidor.setContr(result.getString("contr"));
		}
		
		connection.close();
		System.out.println("CHECKLOGIN REPARTIDOR");
		return repartidor;
	}
	
	public Administrador checkLoginAdmin(String email, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/deliexpress";
		String dbUser = "root";
		String dbPassword = "deliPollo04";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "select * from Administrador where email = ? && contr = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		
		Administrador admin = null;
		
		if (result.next()) {
		    admin = new Administrador();
		    admin.setId_admin(result.getInt("id_admin"));
		    admin.setNombre(result.getString("nombre"));
		    admin.setAp_mat(result.getString("ap_mat"));
		    admin.setAp_pat(result.getString("ap_pat"));
		    admin.setEmail(result.getString("email"));
		    admin.setContr(result.getString("contr"));
		}
		
		connection.close();
		System.out.println("CHECKLOGIN ADMIN");
		return admin;
	}
	//para obtener la lista de direcciones con id de la cuenta 
	//y ser pasados a la pagina principal del repartidor 
	public List<String[]> dirIdOrd()  throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/deliexpress";
		String dbUser = "root";
		String dbPassword = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "select id_orden , cliente.direccion " + 
				"from orden  " + 
				"inner join cliente " + 
				"on orden.Cliente_id_cliente = cliente.id_cliente where estado = \"lista\";"; 
		PreparedStatement statement = connection.prepareStatement(sql);		
		ResultSet result = statement.executeQuery();
		List<String[]> dirs = new ArrayList<String[]>(); 
		while(result.next()){
			String[] temp = new String[2];
			temp[0] = result.getString("cliente.direccion"); 
			temp[1] = result.getString("id_orden"); 
			dirs.add(temp); 
		}
		connection.close(); 
		return dirs; 

	}
}
