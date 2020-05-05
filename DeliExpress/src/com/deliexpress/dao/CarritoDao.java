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
		//String sql = "SELECT a1.precio , a1.nombre_alim, c1.cantidad FROM contenerordalim AS c1 INNER JOIN alimento AS a1 INNER JOIN orden INNER JOIN cliente ON orden.id_orden = c1.orden_id_orden AND cliente.id_cliente = 1 where id_alim = Alimento_id_alim;";
		String sql = "SELECT a1.precio, a1.nombre_alim, c1.cantidad\r\n" + 
				"FROM ContenerOrdAlim AS c1, Alimento AS a1, Orden, Cliente\r\n" + 
				"where Orden.id_orden = c1.Orden_id_orden AND Cliente.id_cliente = 3 "
				+ "group by a1.id_alim;";
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
	
	public void aumentar(int id_orden, String alim) {
		String sql = "CALL aumentar(1,?)" ;
		template.update(sql,alim);
	}
	public void disminuir(int id_orden, String alim) {
		String sql = "CALL disminuir(1,?)" ;
		template.update(sql,alim);
	}
	
	public float precioTotal(int id_carrito) {
		String sql = "SELECT sum(a1.precio * c1.cantidad) as 'precioTotal' FROM contenerordalim AS c1 INNER JOIN alimento AS a1 INNER JOIN orden INNER JOIN cliente ON orden.id_orden = c1.orden_id_orden AND cliente.id_cliente = 1 where id_alim = Alimento_id_alim;";
		//return template.queryForObject(sql,new Object[] {id_carrito}, Float.class);
		System.out.println("precioTotal");
		float pt = 0;
		try {
			return template.queryForObject(sql,Float.class);
		}catch(Exception e) {
			
		}
		return pt;
	}
	
	public void vaciarCarrito(int id_carrito) {
		String sql = "CALL vaciarCarrito(?)" ;
		template.update(sql,id_carrito);
	}
	
	public int sigId() {
		String sql = "select AUTO_INCREMENT " + "from information_schema.TABLES " + "where TABLE_SCHEMA = \"deliexpress\" " + "and table_name = \"cliente\"";
		return template.query(sql, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, 
			DataAccessException{
					if(rs.next()) {
						return rs.getInt("AUTO_INCREMENT");
					}
					return null;
				}
		});
	}
}
