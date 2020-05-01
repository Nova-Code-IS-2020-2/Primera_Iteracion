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

import com.deliexpress.model.Categoria;

public class CategoriaDAO {

	private JdbcTemplate template;    
	
	public CategoriaDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Categoria c){    
	    String sql="insert into Categoria(id_cat, nombre_cat) values(?,?)";    
	    return template.update(sql,c.getId(),c.getNombre());    
	}    
	public int update(Categoria c){    
	    String sql="update Categoria set nombre_cat=? where id_cat=?";    
	    return template.update(sql,c.getNombre(),c.getId());    
	}    
	public int delete(int id){    
	    String sql="delete from Categoria where id_cat=?";    
	    return template.update(sql,id);    
	}   
	
	public List<Categoria> list(){
		String sql = "select * from Categoria";
		List<Categoria> listaCat=template.query(sql, new RowMapper<Categoria>() {
			 @Override
		        public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Categoria aCat = new Categoria();
		 
		            aCat.setId(rs.getInt("id_cat"));
		            aCat.setNombre(rs.getString("nombre_cat"));
		            
		 
		            return aCat;
			 }
		 
		});
		    return listaCat;
	}

	public Categoria get(int id){    
		String sql = "select * from Categoria where id_cat=" + id;
	    return template.query(sql, new ResultSetExtractor<Categoria>() {
	 
	        @Override
	        public Categoria extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Categoria categoria = new Categoria();
	                categoria.setId(rs.getInt("id_cat"));
	                categoria.setNombre(rs.getString("nombre_cat"));
	                return categoria;
	            }
	 
	            return null;
	        }
	 
	    });
	}
}
	        
