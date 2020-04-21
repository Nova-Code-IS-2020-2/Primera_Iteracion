package com.deliexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.beans.Cliente;
import com.deliexpress.beans.Orden;
import com.deliexpress.dao.ClienteDAO;
import com.deliexpress.dao.OrdenDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
@Controller

public class OrdenController {
	
	@Autowired
    private OrdenDAO ordenDAO;
	@Autowired
	private ClienteDAO clienteDAO;
	
	@RequestMapping(value="/ordenes")
	public ModelAndView listaOrden(ModelAndView model) throws IOException{
	    List<Orden> listOrden = ordenDAO.list();
	    model.addObject("listOrden", listOrden);
	    model.setViewName("ordenes");
	 
	    return model;
	}
	
	@RequestMapping(value = "/verOrden", method = RequestMethod.GET)
	public ModelAndView verOrden(HttpServletRequest request) {
	    int ordId = Integer.parseInt(request.getParameter("id"));
	    Orden orden = ordenDAO.get(ordId);
	    Cliente cliente=clienteDAO.get(orden.getCliente());
	    ModelAndView model = new ModelAndView("orden");
	    model.addObject("cliente",cliente);
	    model.addObject("orden", orden);
	 
	    return model;
	}

}
