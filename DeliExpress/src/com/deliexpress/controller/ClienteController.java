package com.deliexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.beans.Cliente;
import com.deliexpress.dao.ClienteDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
@Controller
public class ClienteController {
	
	@Autowired
    private ClienteDAO clienteDAO;
	
	@RequestMapping(value = "/verDireccion", method = RequestMethod.GET)
	public ModelAndView verDireccion(HttpServletRequest request) {
	    int clienteId = Integer.parseInt(request.getParameter("id"));
	    Cliente cliente = clienteDAO.get(clienteId);
	    ModelAndView model = new ModelAndView("verdireccion");
	    model.addObject("cliente", cliente);
	 
	    return model;
	}

}
