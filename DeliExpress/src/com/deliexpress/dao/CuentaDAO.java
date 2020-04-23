package com.deliexpress.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;      
import javax.sql.DataSource;
import java.util.List;
import org.springframework.dao.DataAccessException;    
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
 


import com.deliexpress.beans.Cuenta;

public class CuentaDAO {

	private JdbcTemplate template;    
	
	public CuentaDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Cuenta c){    
	    String sql="insert into Cliente(id_cliente, nombre, ap_pat, ap_mat, email, contr, telefono, direccion ) values(?,?,?,?,?,?,?,?)";    
	    return template.update(sql,c.getId(),c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getTelefono(),c.getDireccion());    
	} 
	
	
	
	public int update(Cuenta c){    
	    String sql="update Cliente set nombre=?, ap_pat=?, ap_mat=?, email=?, contr=?, telefono=?, direccion=? where id_cliente=?";    
	    return template.update(sql,c.getNombre(),c.getAp_pat(),c.getAp_mat(),c.getEmail(),c.getContr(),c.getTelefono(),c.getDireccion(),c.getId());    
	}       
	
	public List<Cuenta> list(){
		String sql = "select * from Cliente";
		List<Cuenta> listaCuentas=template.query(sql, new RowMapper<Cuenta>() {
			 @Override
		        public Cuenta mapRow(ResultSet rs, int rowNum) throws SQLException {
				 	
		            Cuenta cuenta = new Cuenta();
	                cuenta.setId(rs.getInt("id_cliente"));
	                cuenta.setNombre(rs.getString("nombre"));
	                cuenta.setAp_pat(rs.getString("ap_pat"));
	                cuenta.setAp_mat(rs.getString("ap_mat"));
	                cuenta.setEmail(rs.getString("email"));
	                cuenta.setContr(rs.getString("contr"));
	                cuenta.setDireccion(rs.getString("direccion"));
	                cuenta.setTelefono(rs.getString("telefono"));
	                return cuenta;
			 }
		 
		});
		    return listaCuentas;
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
	
	public Cuenta get(int id){    
		String sql = "select * from Cliente where id_cliente = " + id;
		
		
	    return template.query(sql, new ResultSetExtractor<Cuenta>() {
	 
	        @Override
	        public Cuenta extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Cuenta cuenta = new Cuenta();
	                cuenta.setId(rs.getInt("id_cliente"));
	                cuenta.setNombre(rs.getString("nombre"));
	                cuenta.setAp_pat(rs.getString("ap_pat"));
	                cuenta.setAp_mat(rs.getString("ap_mat"));
	                cuenta.setEmail(rs.getString("email"));
	                cuenta.setContr(rs.getString("contr"));
	                cuenta.setDireccion(rs.getString("direccion"));
	                cuenta.setTelefono(rs.getString("telefono"));
	                return cuenta;
	            }
	 
	            return null;
	        }
	 
	    });
	}
}
	        

