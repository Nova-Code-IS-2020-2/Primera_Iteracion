package com.deliexpress.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;   
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.deliexpress.model.*;
import com.mysql.jdbc.Connection;

public class CarritoDao {
	
	private JdbcTemplate template;

	public CarritoDao(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	public List<Carrito> muestraCarrito(){
		System.out.println("MUESTRACARRITO");
		String sql = "SELECT a1.precio , a1.nombre_alim, c1.cantidad\r\n" + 
				"FROM contenerordalim AS c1, alimento AS a1, orden, cliente\r\n" + 
				"where orden.id_orden = c1.orden_id_orden AND cliente.id_cliente = 1\r\n" + 
				"group by a1.id_alim;";
		List<Carrito> listaCarrito = template.query(sql, new RowMapper<Carrito>() { 
			
			@Override
		        public Carrito mapRow(ResultSet rs, int rowNum) throws SQLException {
				 	
				 	Carrito aCat = new Carrito();
				 	System.out.println("mapRow");
				 	
				 	
		            aCat.setPrecio(rs.getFloat("precio"));
		            aCat.setNombre(rs.getString("nombre_alim"));
		            aCat.setCantidad(rs.getInt("cantidad"));
		            System.out.println(aCat.toString());
		            return aCat;
			 }
		 
		});
		    return listaCarrito;
	}
	
	
}
