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

import com.deliexpress.beans.Alimento;

public class AlimentoDAO {
	
private JdbcTemplate template;    
	
	public AlimentoDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Alimento a){    
	    String sql="insert into Alimento(nombre_alim, direc_foto, desc, precio) values(?,?,?,?);"; 
	    return template.update(sql,a.getNombre(),a.getDireccionFoto(), a.getDescripcion(), a.getPrecio());    
	}    
	public int update(Alimento a){    
	    String sql="update Alimento set nombre_alim=?; direc_foto=?; desc=?; precio=? where id=?";    
	    return template.update(sql,a.getNombre(), a.getDireccionFoto(), a.getDescripcion(), a.getPrecio(), a.getId());    
	}    
	public int delete(int id){    
	    String sql="delete from Alimento where id_alim=?";    
	    return template.update(sql,id);    
	}   
	
	public List<Alimento> list(){
		String sql = "select * from Alimento";
		List<Alimento> listaAlim=template.query(sql, new RowMapper<Alimento>() {
			 @Override
		        public Alimento mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Alimento aAli = new Alimento();
		 
		            aAli.setId(rs.getInt("id_alim"));
		            aAli.setDireccionFoto(rs.getString("direc_foto"));
		            aAli.setDescripcion(rs.getString("desc"));
		            aAli.setNombre(rs.getString("nombre_alim"));
		            aAli.setPrecio(rs.getFloat("precio"));
		 
		            return aAli;
			 }
		 
		});
		    return listaAlim;
	}

	public Alimento get(int id){    
		String sql = "select * from Alimento where id_cat=" + id;
	    return template.query(sql, new ResultSetExtractor<Alimento>() {
	 
	        @Override
	        public Alimento extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Alimento alimento = new Alimento();
	                alimento.setId(rs.getInt("id_alim"));
	                alimento.setNombre(rs.getString("nombre_alim"));
	                return alimento;
	            }
	 
	            return null;
	        }
	 
	    });
	}

}
