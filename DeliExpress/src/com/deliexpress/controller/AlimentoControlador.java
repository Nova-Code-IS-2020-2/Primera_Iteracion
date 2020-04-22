package com.deliexpress.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.dao.ConexionDB;
import com.deliexpress.beans.Alimento;

@Controller
public class AlimentoControlador {
	

	ConexionDB con = new ConexionDB();
	JdbcTemplate jT = new JdbcTemplate(con.conectarDB());
	org.springframework.web.servlet.ModelAndView mav = new ModelAndView();
	int id;
	List datos;
	
	@RequestMapping("menuAdmin.jsp")
	public ModelAndView Listar() {
		String sql = "SELECT * FROM Alimento";
		datos = this.jT.queryForList(sql);
		mav.addObject("lista", datos);
		mav.setViewName("menuAdmin");
		return mav;
	}
	
	@RequestMapping(value="agregarAlimento.jsp", method=RequestMethod.GET)
	public ModelAndView Agregar() {
		mav.addObject(new Alimento());
		mav.setViewName("agregarAlimento");
		return mav;
	}
	
	@RequestMapping(value="agregarAlimento.jsp", method=RequestMethod.POST)
	public ModelAndView Agregar(Alimento a) {
		String sql="insert into Alimento (nombre, direc_foto, descripcion, precio) values(?,?,?,?)";
		this.jT.update(sql,a.getNombre(), a.getDireccionFoto(), a.getDescripcion(), a.getPrecio());
		return new ModelAndView("redirect:/menuAdmin.jsp");
	}
	
	@RequestMapping(value="editarAlimento.jsp", method=RequestMethod.GET)
	public ModelAndView Editar(HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter("id"));
		String sql="select * from persona where id="+id;
		datos = this.jT.queryForList(sql);
		mav.addObject("lista",datos);
		mav.setViewName("editarAlimento");
		return mav;
	}
	
	@RequestMapping(value="editarAlimento.jsp", method=RequestMethod.POST)
	public ModelAndView Editar(Alimento a) {
		String sql="update alimento set nombre=?; direc_foto=?; descripcion=?; precio=? where id=?"+id;
		this.jT.update(sql,a.getNombre(), a.getDireccionFoto(), a.getDescripcion(), a.getPrecio());
		return new ModelAndView("redirect:/menuAdmin.jsp");
	}
	
	@RequestMapping("eliminaAlimento.jsp")
	public ModelAndView Eliminar(HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter("id"));
		String sql="delete from persona where id="+id;
		return new ModelAndView("redirect:/menuAdmin.jsp");
	}
}
