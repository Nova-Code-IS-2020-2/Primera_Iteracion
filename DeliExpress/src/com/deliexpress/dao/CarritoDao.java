package com.deliexpress.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deliexpress.model.*;

public class CarritoDao {
	private Conexion con;
	private Connection connection;

	public CarritoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar artículo
	public boolean insertar(Carrito carrito) throws SQLException {
		String sql = "INSERT INTO carrito (cantidad, idAlimento, idOrden) VALUES (?, ?, ?)";
		System.out.println("hola");
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, carrito.getCantidad());
		statement.setInt(2, carrito.getIdAlimento());
		statement.setInt(3, carrito.getIdOrden());
		System.out.println("hola");
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todos los productos
	public List<Carrito> listarCarritos() throws SQLException {

		List<Carrito> listaCarritos = new ArrayList<Carrito>();
		String sql = "SELECT * FROM carrito";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		while (resulSet.next()) {
			int cantidad = resulSet.getInt("cantidad");
			int idAlimento  = resulSet.getInt("idAlimento");
			int idOrden = resulSet.getInt("idOrden");
			Carrito carrito = new Carrito(cantidad,idAlimento,idOrden);
			listaCarritos.add(carrito);
		}
		con.desconectar();
		return listaCarritos;
	}

	// obtener por id
	public Carrito obtenerPorId(int id) throws SQLException {
		Carrito carrito = null;

		String sql = "SELECT * FROM carrito WHERE Alimento_id_alim= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			carrito = new Carrito(res.getInt("cantidad"), res.getInt("idAlimento"), res.getInt("idOrden"));
		}
		res.close();
		con.desconectar();

		return carrito;
	}

	// actualizar
	public boolean aumentar(Carrito carrito) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE carrito SET cantidad=? WHERE Alimento_id_alim=?=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, carrito.getCantidad());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	public boolean disminuir(Carrito carrito) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE carrito SET cantidad=? WHERE Alimento_id_alim=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, carrito.getCantidad());
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}
	
	
	//eliminar
	public boolean eliminar(Carrito carrito) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE * FROM carrito ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}
