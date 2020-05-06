package com.deliexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.Cliente;
import com.deliexpress.model.Orden;
import com.deliexpress.dao.ClienteDAO;
import com.deliexpress.dao.OrdenDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
@Controller
public class ClienteController {
	
	@Autowired
    private ClienteDAO clienteDAO;
	
	@Autowired
    private OrdenDAO ordenDAO;
	
	@RequestMapping(value = "/verDireccion", method = RequestMethod.GET)
	public ModelAndView verDireccion(HttpServletRequest request) {
	    int clienteId = Integer.parseInt(request.getParameter("id_cliente"));
	    int ordenId =Integer.parseInt(request.getParameter("id_orden"));
	    Orden orden = ordenDAO.get(ordenId);
	    Cliente cliente = clienteDAO.get(clienteId);
	    ModelAndView model = new ModelAndView("verdireccion");
	    model.addObject("cliente", cliente);
	    model.addObject("orden", orden);
	    return model;
	}

}
