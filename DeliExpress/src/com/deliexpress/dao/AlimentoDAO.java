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

import com.deliexpress.model.Alimento;

public class AlimentoDAO {

private JdbcTemplate template;

	public AlimentoDAO(DataSource datasource) {
		this.template=new JdbcTemplate(datasource);
	}

	public void setTemplate(JdbcTemplate template) {
	    this.template = template;
	}
	public int save(Alimento a){
	    String sql="insert into Alimento (direc_foto, descripcion, nombre_alim, precio, Categoria_id_cat) values(?,?,?,?,?)";
	    return template.update(sql,a.getDireccionFoto(), a.getDescripcion(), a.getNombre(), a.getPrecio(), a.getCategoria());
	}
	public int update(Alimento a){
	    String sql="update Alimento set direc_foto=?, descripcion=?, nombre_alim=?, precio=?, Categoria_id_cat=? where id_alim=?";
	    return template.update(sql, a.getDireccionFoto(), a.getDescripcion(), a.getNombre(), a.getPrecio(), a.getCategoria(),  a.getId());

	}
	public int delete(int id){
	    String sql="delete from Alimento where id_alim=?";
	    return template.update(sql,id);
	}

	public List<Alimento> list(int idCat){
		String sql = "select * from Alimento where Categoria_id_cat="+idCat;
		List<Alimento> listaAlim=template.query(sql, new RowMapper<Alimento>() {
			 @Override
		        public Alimento mapRow(ResultSet rs, int rowNum) throws SQLException {
		            Alimento aAli = new Alimento();

		            aAli.setId(rs.getInt("id_alim"));
		            aAli.setDireccionFoto(rs.getString("direc_foto"));
		            aAli.setDescripcion(rs.getString("descripcion"));
		            aAli.setNombre(rs.getString("nombre_alim"));
		            aAli.setPrecio(rs.getFloat("precio"));
		            aAli.setCategoria(rs.getInt("Categoria_id_cat"));

		            return aAli;
			 }

		});
		    return listaAlim;
	}

	public Alimento get(int id){
		String sql = "select * from Alimento where id_alim=" + id;
	    return template.query(sql, new ResultSetExtractor<Alimento>() {

	        @Override
	        public Alimento extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Alimento alimento = new Alimento();
	                alimento.setId(rs.getInt("id_alim"));
	                alimento.setNombre(rs.getString("nombre_alim"));
	                alimento.setDescripcion(rs.getString("descripcion"));
	                alimento.setDireccionFoto(rs.getString("direc_foto"));
	                alimento.setPrecio(rs.getFloat("precio"));
	                alimento.setCategoria(rs.getInt("Categoria_id_cat"));
	                return alimento;
	            }
	            return null;
	        }

	    });
	}

}
