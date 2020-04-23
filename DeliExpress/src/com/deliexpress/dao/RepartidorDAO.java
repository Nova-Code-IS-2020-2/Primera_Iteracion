package com.deliexpress.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.deliexpress.beans.Categoria;
import com.deliexpress.beans.Repartidor;

public class RepartidorDAO {
	private JdbcTemplate template;   
	public RepartidorDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 
	public Repartidor getWithContr(String contr) {
		String sql = "select * from repartidor where contr = " + contr;
	    return template.query(sql, new ResultSetExtractor<Repartidor>() {
	 
	        @Override
	        public Repartidor extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Repartidor rep = new Repartidor();
	                rep.setIdRepartidor(rs.getInt("id_repartidor"));
	                rep.setNombre(rs.getString("nombre"));
	                return rep;
	            }
	 
	            return null;
	        }
	 
	    });
	}
}
