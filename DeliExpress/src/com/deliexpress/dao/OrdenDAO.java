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

import com.deliexpress.beans.Orden;
import com.deliexpress.model.Categoria;

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

	}
	public int updateRepartidor(int idOrden,int idRepartidor){    
	    String sql="update Orden set Repartidor_id_repartidor=? , estado=\"enproceso\" "
	    		+ "where id_orden=?";    
	    return template.update(sql,idRepartidor,idOrden);    
	}    
}
