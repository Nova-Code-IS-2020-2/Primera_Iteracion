package com.deliexpress.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.deliexpress.beans.Alimento;
import com.deliexpress.beans.Categoria;

public class AlimentoDAO {

	private JdbcTemplate template;    
	
	public AlimentoDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
   
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public List<Alimento> list(){
		String sql = "select * from alimento";
		List<Alimento> listaAlim=template.query(sql, new RowMapper<Alimento>() {
			 @Override
		        public Alimento mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Alimento alim = new Alimento();
		 
		            alim.setIdAlimento(rs.getInt("id_alim"));
		            alim.setDesc(rs.getString("desc"));
		            alim.setNombreAlim(rs.getString("nombre_alim"));
		             
		            return alim;
			 }
		 
		});
		    return listaAlim;
	}
}
