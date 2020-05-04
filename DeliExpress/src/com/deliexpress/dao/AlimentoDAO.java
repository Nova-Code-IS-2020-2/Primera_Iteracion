package com.deliexpress.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.deliexpress.model.Alimento;
import com.deliexpress.model.Categoria;

public class AlimentoDAO {
	private JdbcTemplate template;

	public AlimentoDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	public Alimento get(int idAlim){
		String sql = "select * from alimento where id_alim=" + idAlim;
	    return template.query(sql, new ResultSetExtractor<Alimento>() {
	 
	        @Override
	        public Alimento extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) { 
	                Alimento al = new Alimento();
	                al.setId(rs.getInt("id_alim"));
	                al.setFoto(rs.getString("direc_foto"));
	                al.setNombre(rs.getString("nombre_alim"));
	                al.setPrecio(rs.getFloat("precio"));
	                return al;
	            }
	            return null;
	        }
	 
	    });
	}
	public List<Alimento> alimentos()  throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/deliexpress";
		String dbUser = "root";
		String dbPassword = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "select id_alim , nombre_alim " + 
				"from alimento"; 
		PreparedStatement statement = connection.prepareStatement(sql);		
		ResultSet result = statement.executeQuery();
		List<Alimento> alims = new ArrayList<Alimento>(); 
		while(result.next()){
			Alimento a = new Alimento(); 
			a.setId(result.getInt("id_alim")); 
			a.setNombre(result.getString("nombre_alim")); 
			alims.add(a); 
		}
		connection.close(); 
		return alims; 

	}
}
