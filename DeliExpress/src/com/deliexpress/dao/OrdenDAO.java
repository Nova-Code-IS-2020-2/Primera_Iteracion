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

import com.deliexpress.beans.Categoria;
import com.deliexpress.beans.Orden;

public class OrdenDAO {

	private JdbcTemplate template;   
	public OrdenDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	public int ordenInicial(Orden o){    
	    String sql="insert into orden (Cliente_id_cliente) values(?)";    
	    return template.update(sql,o.getIdCliente());    
	}  
	public List<String[]> dirIdOrd(){
		String sql = "select id_orden , cliente.direccion " + 
				"from orden  " + 
				"inner join cliente " + 
				"on orden.Cliente_id_cliente = cliente.id_cliente where estado = \"listo\";"; 
		List<String[]> listaDir= template.query(sql, new RowMapper<String[]>() {
			 @Override
		        public String[] mapRow(ResultSet rs, int rowNum) throws SQLException { 
					String[] tmp = new String[2]; 
				 	tmp[0] = rs.getString("direccion"); 
				 	tmp[1] = rs.getString("id_orden"); 
		            return tmp;
			 }
		 
		});
		    return listaDir;
	}
	//obtiene el siguiente id 
	public int sigId(){    
		String sql = "select AUTO_INCREMENT " + 
				"from information_schema.TABLES " + 
				"where TABLE_SCHEMA = \"deliexpress\" " + 
				"and table_name = \"orden\""; 
	    return template.query(sql, new ResultSetExtractor<Integer>() {
	 
	        @Override
	        public Integer extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) { 
	                return rs.getInt("AUTO_INCREMENT");
	            }
	 
	            return null;
	        }
	 
	    });
	}
	public int agregarAlimOrd(int idOrd,int idAlim) {
		  String sql="insert into contenerordalim (Alimento_id_alim,Orden_id_orden,cantidad) values (?,?,1)";    
		   return template.update(sql, idAlim,idOrd);   
	}
	public int asignarRepartidor(int idRep,int idOrden) {
			//hacer dos updates asignar al repartidor y poner la orden en proceso 
		  String sql="update orden set Repartidor_id_repartidor = ? , estado = \"enproceso\" where id_orden = ?";    
		   return template.update(sql, idRep,idOrden);   
	}
	public int asignarEstadoListo(int idOrden) {
		String sql = "update orden set estado = \"listo\" where id_orden = ? "; 
		return template.update(sql,idOrden); 
	}
	
	
}
	        

