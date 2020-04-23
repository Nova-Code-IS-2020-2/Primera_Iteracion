package com.deliexpress.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.dao.ConexionDB;
import com.deliexpress.beans.Repartidor;

@Controller
public class RepartidorControlador {
	

	ConexionDB con = new ConexionDB();
	JdbcTemplate jT = new JdbcTemplate(con.conectarDB());
	org.springframework.web.servlet.ModelAndView mav = new ModelAndView();
	int id;
	List datos;
	
	@RequestMapping("menuAdmin.jsp")
	public ModelAndView Listar() {
		String sql = "SELECT * FROM Repartidor";
		datos = this.jT.queryForList(sql);
		mav.addObject("lista", datos);
		mav.setViewName("repartidorAdmin");
		return mav;
	}
	
	@RequestMapping(value="agregarRepartidor.jsp", method=RequestMethod.GET)
	public ModelAndView Agregar() {
		mav.addObject(new Repartidor());
		mav.setViewName("agregarRepartidor");
		return mav;
	}
	
	@RequestMapping(value="agregarRepartidor.jsp", method=RequestMethod.POST)
	public ModelAndView Agregar(Repartidor r) {
		String sql="insert into Repartidor (nombre, ap_pat, ap_mat, email, contr) values(?,?,?,?,?)";
		this.jT.update(sql,r.getNombre(), r.getaPat(), r.getaMat(), r.getEmail(), r.getContr());
		return new ModelAndView("redirect:/repartidorAdmin.jsp");
	}
	
	@RequestMapping(value="editarAlimento.jsp", method=RequestMethod.GET)
	public ModelAndView Editar(HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter("id"));
		String sql="select * from Repartidor where id="+id;
		datos = this.jT.queryForList(sql);
		mav.addObject("lista",datos);
		mav.setViewName("editarRepartidor");
		return mav;
	}
	
	@RequestMapping(value="editarRepartidor.jsp", method=RequestMethod.POST)
	public ModelAndView Editar(Repartidor a) {
		String sql="update Repartidor set nombre=?; ap_pat=?; ap_mat=?; email=?; contr=? where id=?"+id;
		this.jT.update(sql,r.getNombre(), r.getaPat(), r.getaMat(), r.getEmail, r.getContr());
		return new ModelAndView("redirect:/repartidorAdmin.jsp");
	}
	
	@RequestMapping("eliminaAlimento.jsp")
	public ModelAndView Eliminar(HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter("id"));
		String sql="delete from Repartidor where id="+id;
		this.jT.update(sql);
		return new ModelAndView("redirect:/repartidorAdmin.jsp");
	}
}
