package com.deliexpress.controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.beans.Alimento;
import com.deliexpress.beans.Categoria;
import com.deliexpress.beans.Credenciales;
import com.deliexpress.beans.Orden;
import com.deliexpress.beans.Repartidor;
import com.deliexpress.dao.CategoriaDAO;
import com.deliexpress.dao.OrdenDAO;
import com.deliexpress.dao.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.*;

@Controller
public class RUD_Carrito {
	@Autowired
	private OrdenDAO ordenDAO; 
	@Autowired 
	private AlimentoDAO alimentoDAO; 
	@RequestMapping(value = "/agregarCarrito", method = RequestMethod.GET)
	public ModelAndView agregarCarrito(HttpServletRequest request) {
	    int idCliente = Integer.parseInt(request.getParameter("idCliente"));
	    int idOrden = Integer.parseInt(request.getParameter("idOrden")); 
	    int idAlimento  = Integer.parseInt(request.getParameter("idAlim"));
	    ordenDAO.agregarAlimOrd(idOrden, idAlimento); 
	    ModelAndView model = new ModelAndView(); 
	    model.addObject("idCliente",idCliente); 
		model.addObject("idOrden",idOrden); 
		List<Alimento> alims = alimentoDAO.list();
		model.addObject("alims",alims);
		model.setViewName("RUD_CarritoIH"); 
		return model; 
	}
	
}
