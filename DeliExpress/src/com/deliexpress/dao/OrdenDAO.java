package com.deliexpress.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.deliexpress.model.Alimento;
import com.deliexpress.model.Carrito;
import com.deliexpress.model.Categoria;
import com.deliexpress.model.Orden;

public class OrdenDAO {
private JdbcTemplate template;    
	
	public OrdenDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 
	
	public List<Orden> list(){
		String sql = "select * from Orden";
		List<Orden> listaOrd=template.query(sql, new RowMapper<Orden>() {
			 @Override
		        public Orden mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Orden aOrd = new Orden();
		 
		            aOrd.setId(rs.getInt("id_orden"));
		            aOrd.setPrecio(rs.getFloat("precio"));
		            aOrd.setRepartidor(rs.getInt("Repartidor_id_repartidor"));
		            aOrd.setCliente(rs.getInt("Cliente_id_cliente"));
		            
		 
		            return aOrd;
			 }
		 
		});
		    return listaOrd;
	}
	
	public Orden get(int id){    
		String sql = "select * from Orden where id_orden=" + id;
	    return template.query(sql, new ResultSetExtractor<Orden>() {
	 
	        @Override
	        public Orden extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Orden orden = new Orden();
	                orden.setId(rs.getInt("id_orden"));
	                orden.setPrecio(rs.getFloat("precio"));
	                orden.setRepartidor(rs.getInt("Repartidor_id_repartidor"));
		            orden.setCliente(rs.getInt("Cliente_id_cliente"));
	                return orden;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public int updateRepartidor(int idOrden,int idRepartidor){    
	    String sql="update Orden set Repartidor_id_repartidor=? , estado=\"enproceso\" "
	    		+ "where id_orden=?";    
	    return template.update(sql,idRepartidor,idOrden);    
	}    
	public int sigId() {
		String sql = "select AUTO_INCREMENT " + "from information_schema.TABLES " + "where TABLE_SCHEMA = \"deliexpress\" " + "and table_name = \"orden\"";
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
	public int guardarOrden(Carrito carrito,int idCliente) {
		float precio = 0; 
		Iterator<Alimento> it = carrito.getAlimentos().iterator();
		int idOrd = this.sigId(); 
		String sql="insert into orden (Cliente_id_cliente) values (?)"; 
		template.update(sql,idCliente); 
		while(it.hasNext()) {
			Alimento al = (Alimento)it.next();
			sql = "insert into contenerordalim (Alimento_id_alim,Orden_id_orden,cantidad) values (?,?,1)"; 
			template.update(sql,al.getId(),idOrd); 
			precio+=al.getPrecio(); 
		}
		System.out.print("se guardo en " + idOrd);
		//modificar el precio 
		sql = "update orden "
				+ "set precio=?" + 
				"where id_orden=?"; 
		return template.update(sql,precio,idOrd); 
	}

}
