package com.deliexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.deliexpress.dao.CuentaDAO;
import com.deliexpress.model.Categoria;
import com.deliexpress.model.Cliente;


@Controller
public class ClienteController {
	
	@Autowired
	private CuentaDAO cuentaDAO;
	
	@RequestMapping(value = "/crearCliente", method = RequestMethod.POST)
	public ModelAndView crearCliente(@ModelAttribute Cliente cliente) {
	    cuentaDAO.save(cliente);
	    return new ModelAndView("redirect:/menucliente");
	}
	
	@RequestMapping(value = "/agregarCliente", method = RequestMethod.GET)
	public ModelAndView agregarCliente(ModelAndView model) {
	    Cliente cliente = new Cliente();
	    model.addObject("cliente", cliente);
	    model.setViewName("registrarcliente");
	    return model;
	}
}
