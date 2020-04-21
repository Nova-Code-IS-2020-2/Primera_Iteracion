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

import com.deliexpress.beans.Cliente;

public class ClienteDAO {
	
	private JdbcTemplate template;
	
	public ClienteDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public Cliente get(int id){    
		String sql = "select * from Cliente where id_cliente=" + id;
	    return template.query(sql, new ResultSetExtractor<Cliente>() {
	 
	        @Override
	        public Cliente extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setId(rs.getInt("id_cliente"));
	                cliente.setNombre(rs.getString("nombre"));
	                cliente.setApPat(rs.getString("ap_pat"));
	                cliente.setApMat(rs.getString("ap_mat"));
	                cliente.setEmail(rs.getString("email"));
	                cliente.setContraseña(rs.getString("contr"));
	                cliente.setTelefono(rs.getString("telefono"));
	                cliente.setDireccion(rs.getString("direccion"));
	                return cliente;
	            }
	 
	            return null;
	        }
	 
	    });
	}

}
