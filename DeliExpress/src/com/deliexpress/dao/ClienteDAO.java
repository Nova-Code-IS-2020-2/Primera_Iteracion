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
import com.deliexpress.beans.Repartidor;

public class ClienteDAO {

	private JdbcTemplate template;    
	
	public ClienteDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Cliente c){    
	    String sql="insert into Cliente(id_cliente, nombre) values(?,?)";    
	    return template.update(sql,c.getId(),c.getNombre());    
	}    
	public int update(Cliente c){    
	    String sql="update Cliente set nombre=? where id_cliente=?";    
	    return template.update(sql,c.getNombre(),c.getId());    
	}    
	public int delete(int id){    
	    String sql="delete from Cliente where id_cliente=?";    
	    return template.update(sql,id);    
	}   
	
	public List<Cliente> list(){
		String sql = "select * from Cliente";
		List<Cliente> listaCliente =template.query(sql, new RowMapper<Cliente>() {
			 @Override
		        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Cliente c = new Cliente();
		            c.setId(rs.getInt("id_cliente"));
		            c.setNombre(rs.getString("nombre"));
		            
		 
		            return c;
			 }
		 
		});
		    return listaCliente;
	}

	public Cliente get(int id){    
		String sql = "select * from Cliente where id_cat=" + id;
	    return template.query(sql, new ResultSetExtractor<Cliente>() {
	 
	        @Override
	        public Cliente extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Cliente cl = new Cliente();
	                cl.setId(rs.getInt("id_cliente"));
	                cl.setNombre(rs.getString("nombre"));
	                return cl;
	            }
	 
	            return null; 
	        }
	 
	    });
	}
	public Cliente getWithContr(String contr) {
		String sql = "select * from cliente where contr = " + contr;
	    return template.query(sql, new ResultSetExtractor<Cliente>() {
	 
	        @Override
	        public Cliente extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Cliente cl = new Cliente();
	                cl.setId(rs.getInt("id_cliente"));
	                cl.setNombre(rs.getString("nombre"));
	                return cl;
	            }
	 
	            return null;
	        }
	 
	    });
	}
}