package com.deliexpress.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;      
import javax.sql.DataSource;
import java.util.List;
import org.springframework.dao.DataAccessException;    
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
 


import com.deliexpress.model.*;

public class CuentaDAO {

	private JdbcTemplate template;    
	
	public CuentaDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Cliente c){    
	    String sql="insert into Cliente(id_cliente, nombre, ap_pat, ap_mat, email, contr, telefono, direccion ) values(?,?,?,?,?,?,?,?)";    
	    return template.update(sql,c.getId_cliente(),c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getTelefono(),c.getDireccion());    
	} 
	
	
	
	public int update(Cliente c){    
	    String sql="update Cliente set nombre=?, ap_pat=?, ap_mat=?, email=?, contr=?, telefono=?, direccion=? where id_cliente=?";    
	    return template.update(sql,c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getTelefono(),c.getDireccion(),c.getId_cliente());    
	}      
	public int update(Administrador c){    
	    String sql="update Administrador set nombre=?, ap_pat=?, ap_mat=?, email=?, contr=? where id_cliente=?";    
	    return template.update(sql,c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getId_admin());    
	}      
	
	public List<Cliente> list(){
		String sql = "select * from Cliente";
		List<Cliente> listaClientes=template.query(sql, new RowMapper<Cliente>() {
			 @Override
		        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
				 	
		            Cliente cliente = new Cliente();
	                cliente.setId_cliente(rs.getInt("id_cliente"));
	                cliente.setNombre(rs.getString("nombre"));
	                cliente.setAp_pat(rs.getString("ap_pat"));
	                cliente.setAp_mat(rs.getString("ap_mat"));
	                cliente.setEmail(rs.getString("email"));
	                cliente.setContr(rs.getString("contr"));
	                cliente.setDireccion(rs.getString("direccion"));
	                cliente.setTelefono(rs.getString("telefono"));
	                return cliente;
			 }
		 
		});
		    return listaClientes;
	}
	public List<Administrador> listAdmin(){
		String sql = "select * from Administrador";
		List<Administrador> listaAdministradors=template.query(sql, new RowMapper<Administrador>() {
			 @Override
		        public Administrador mapRow(ResultSet rs, int rowNum) throws SQLException {
				 	
		            Administrador admin = new Administrador();
	                admin.setId_admin(rs.getInt("id_admin"));
	                admin.setNombre(rs.getString("nombre"));
	                admin.setAp_pat(rs.getString("ap_pat"));
	                admin.setAp_mat(rs.getString("ap_mat"));
	                admin.setEmail(rs.getString("email"));
	                admin.setContr(rs.getString("contr"));
	                
	                return admin;
			 }
		 
		});
		    return listaAdministradors;
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
	
	public Cliente get(int id){    
		String sql = "select * from Cliente where id_cliente = " + id;
		
		
	    return template.query(sql, new ResultSetExtractor<Cliente>() {
	 
	        @Override
	        public Cliente extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Cliente cliente = new Cliente();
	                cliente.setId_cliente(rs.getInt("id_cliente"));
	                cliente.setNombre(rs.getString("nombre"));
	                cliente.setAp_pat(rs.getString("ap_pat"));
	                cliente.setAp_mat(rs.getString("ap_mat"));
	                cliente.setEmail(rs.getString("email"));
	                cliente.setContr(rs.getString("contr"));
	                cliente.setDireccion(rs.getString("direccion"));
	                cliente.setTelefono(rs.getString("telefono"));
	                return cliente;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	
	public Administrador getAdmin(int id){    
		String sql = "select * from administrador where id_admin = " + id;
		
		
	    return template.query(sql, new ResultSetExtractor<Administrador>() {
	 
	        @Override
	        public Administrador extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Administrador admin = new Administrador();
	                admin.setId_admin(rs.getInt("id_admin"));
	                admin.setNombre(rs.getString("nombre"));
	                admin.setAp_pat(rs.getString("ap_pat"));
	                admin.setAp_mat(rs.getString("ap_mat"));
	                admin.setEmail(rs.getString("email"));
	                admin.setContr(rs.getString("contr"));
	                return admin;
	            }
	 
	            return null;
	        }
	 
	    });
	}
}
	     