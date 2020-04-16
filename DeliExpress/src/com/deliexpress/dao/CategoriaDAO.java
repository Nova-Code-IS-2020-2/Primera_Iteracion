package com.deliexpress.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;   
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.deliexpress.beans.Categoria;

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
	    return template.update(sql,c.getId(),c.getName());    
	}    
	public int update(Categoria c){    
	    String sql="update Categoria set nombre_cat=? where id_cat=?";    
	    return template.update(sql,c.getName(),c.getId());    
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
		            aCat.setName(rs.getString("nombre_cat"));
		 
		            return aCat;
			 }
		 
		});
		 
		    return listaCat;
	}
	public Categoria get(int id){    
	    String sql="select * from Categoria where id="+id;    
	    return template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Categoria.class));    
	}    
	        
}
