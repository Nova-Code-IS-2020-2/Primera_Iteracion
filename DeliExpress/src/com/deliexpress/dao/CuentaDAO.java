package com.deliexpress.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;      
import javax.sql.DataSource;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

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
	    String sql="insert into Cliente(id_cliente,nombre, ap_pat, ap_mat, email, contr, telefono, direccion ) values(?,?,?,?,?,?,?,?)";    
	    return template.update(sql,c.getId_cliente(),c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getTelefono(),c.getDireccion());    
	} 
	
	
	
	public int update(Cliente c){    
	    String sql="update Cliente set nombre=?, ap_pat=?, ap_mat=?, email=?, contr=?, telefono=?, direccion=? where id_cliente=?";    
	    return template.update(sql,c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getTelefono(),c.getDireccion(),c.getId_cliente());    
	}      
	public int update(Administrador c){    
	    String sql="update Administrador set nombre=?, ap_pat=?, ap_mat=?, email=?, contr=? where id_admin=?";    
	    return template.update(sql,c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getId_admin());    
	}    
	public int update(Repartidor c){    
	    String sql="update Repartidor set nombre=?, ap_pat=?, ap_mat=?, email=?, contr=? where id_repartidor=?";    
	    return template.update(sql,c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getId_repartidor());    
	}    
	
	public List<Cliente> list(){
		System.out.println("List");
		String sql = "select * from cliente";
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
		System.out.println("List2");
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
	
	public List<Repartidor> listaRep(){
		String sql = "select * from repartidor";
		List<Repartidor> listarep=template.query(sql, new RowMapper<Repartidor>() {
			 @Override
		        public Repartidor mapRow(ResultSet rs, int rowNum) throws SQLException {
				 	
		            Repartidor rep = new Repartidor();
		            rep.setId_repartidor(rs.getInt("id_repartidor"));
		            rep.setNombre(rs.getString("nombre"));
		            rep.setAp_pat(rs.getString("ap_pat"));
		            rep.setAp_mat(rs.getString("ap_mat"));
		            rep.setEmail(rs.getString("email"));
		            rep.setContr(rs.getString("contr"));
	                
	                return rep;
			 }
		 
		});
		    return listarep;
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
	
	public boolean checkTel(String tel) {
		System.out.println("checkTel");
		if(tel.length() > 8) {
			return false;
		}
		return true;
	}
	
	public boolean checkEmail(String email) {
		System.out.println("checkEmail");
		if(adminEmail(email)==null)
			return true;
		else 
			return false;
	}
	
	public Administrador adminEmail(String email){    
		System.out.println("admin Email");
		String sql = "select * from administrador where email = ?";
		return (Administrador) template.queryForObject(
				sql,
				new Object[]{email},
				new BeanPropertyRowMapper(Administrador.class));
	}
	public Repartidor repEmail(String email){    
		String sql = "select * from repartidor where email = " + email;
		return template.query(sql, new ResultSetExtractor<Repartidor>() {
	    	@Override
	        public Repartidor extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Repartidor rep = new Repartidor();
	            	rep.setId_repartidor(rs.getInt("id_repartidor"));
	            	rep.setNombre(rs.getString("nombre"));
	            	rep.setAp_pat(rs.getString("ap_pat"));
	            	rep.setAp_mat(rs.getString("ap_mat"));
	            	rep.setEmail(rs.getString("email"));
	            	rep.setContr(rs.getString("contr"));
	                return rep;
	            }
            	return null;
	        }
	    });
	}
	public Administrador adminTel(String tel){    
		String sql = "select * from administrador where id_admin = " + tel;
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
	//para obtener la lista de direcciones con id de la cuenta 
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
	
}
	    
