package com.deliexpress.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.deliexpress.model.Categoria;

public class OrdenDAO {
private JdbcTemplate template;    
	
	public OrdenDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	public int updateRepartidor(int idOrden,int idRepartidor){    
	    String sql="update Orden set Repartidor_id_repartidor=? , estado=\"enproceso\" "
	    		+ "where id_orden=?";    
	    return template.update(sql,idRepartidor,idOrden);    
	}    
}
