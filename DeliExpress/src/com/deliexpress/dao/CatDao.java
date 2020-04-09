package com.deliexpress.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;  
import com.deliexpress.beans.Categoria;

public class CatDao {

	JdbcTemplate template;    
    
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int save(Categoria p){    
	    String sql="insert into Categoria(nombre_cat) values('"+p.getName()+"')";    
	    return template.update(sql);    
	}    
	public int update(Categoria p){    
	    String sql="update Categoria set name='"+p.getName()+"";    
	    return template.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from Categoria where id="+id+"";    
	    return template.update(sql);    
	}    
	public Categoria getCatById(int id){    
	    String sql="select * from Categoria where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Categoria>(Categoria.class));    
	}    
	        
}
