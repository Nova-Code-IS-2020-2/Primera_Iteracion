package com.deliexpress.controller;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.model.Administrador;
import com.deliexpress.model.Categoria;
import java.io.*;
import java.sql.SQLException;

import com.deliexpress.model.Cliente;
import com.deliexpress.model.Orden;
import com.deliexpress.model.Repartidor;
import com.deliexpress.dao.ClienteDAO;
import com.deliexpress.dao.IniciarSesionDAO;
import com.deliexpress.dao.OrdenDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.*;
@Controller

public class OrdenController {
	
	@Autowired
    private OrdenDAO ordenDAO;
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping(value="/ordenes")
	 public ModelAndView ordenes(HttpServletRequest request)throws ServletException{
		 HttpSession s = request.getSession();
		 if(s.getAttribute("orden") == null) {
			 try {
				 IniciarSesionDAO isDAO = new IniciarSesionDAO();
				 List<String[]> dirs = isDAO.dirIdOrd();
				 ModelAndView mav = null;
				 if (s.getAttribute("admin") == null) {
					 mav=new ModelAndView("seleccionarcomida");
				 }else {
					 mav=new ModelAndView("seleccionarcomidaAdmin");
				 }
				 mav.addObject("dirs", dirs);
				 return mav;
			 }catch (SQLException | ClassNotFoundException ex) {
		          throw new ServletException(ex);
			 }
		 }else {
			 return new ModelAndView("redirect:/orden");
		 }
	}
	
	
	
	
	@RequestMapping(value = "/orden",  method = RequestMethod.GET)
	public ModelAndView orden(HttpServletRequest request) {  
	    HttpSession s = request.getSession();
	    Orden orden = (Orden) s.getAttribute("orden");
	    ModelAndView model = new ModelAndView("orden");
	    Cliente cliente=clienteDAO.get(orden.getCliente());
	    model.addObject("cliente",cliente);
	 
	    return model;
	}
	@RequestMapping(value = "/entregar", method = RequestMethod.GET)
	public ModelAndView entregar(HttpServletRequest request){
		HttpSession s = request.getSession();
	    Repartidor r = (Repartidor) s.getAttribute("rep");
	    Orden orden = (Orden) s.getAttribute("orden");
	    
	    s.setAttribute("orden", null);
		ordenDAO.updateRepartidor2(orden.getId(), r.getId_repartidor());
		return new ModelAndView("entregado");
	}
	@RequestMapping(value = "/verOrden", method = RequestMethod.GET)
	public ModelAndView verOrden(HttpServletRequest request) {  
	    int ordId = Integer.parseInt(request.getParameter("id"));
	    HttpSession s = request.getSession();
	    Repartidor r = (Repartidor) s.getAttribute("rep");
	    Orden orden = (Orden) s.getAttribute("orden");
	    ModelAndView model;
	    if(r != null) {
	    	if(orden == null) {
	    		
	    		orden = ordenDAO.get(ordId);
	    		s.setAttribute("orden", orden);
	    		ordenDAO.updateRepartidor(ordId, r.getId_repartidor());
	    	}
	    	model= new ModelAndView("orden");
	    	model.addObject("idRepartidor", r.getId_repartidor());
		    model.addObject("ordId",ordId);
	    }else {
	    	System.out.println("Admin");
	    	model = new ModelAndView("ordenAdmin");
	    	orden = ordenDAO.get(ordId);
	    	model.addObject("orden", orden);
	    }
	    Cliente cliente=clienteDAO.get(orden.getCliente());
	    model.addObject("cliente",cliente);
	 
	    return model;
	}

}