package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.Cliente;
import com.deliexpress.dao.CuentaDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class MiPerfil{
	
	@Autowired
    private CuentaDAO clienteDAO;
 
	@RequestMapping(value = "/registrate", method = RequestMethod.GET)
	public ModelAndView registrate(ModelAndView model) {
	    Cliente cliente = new Cliente();
	    model.addObject("cliente", cliente);
	    model.setViewName("catform");
	    return model;
	}
	public Cliente nuevaCliente(Cliente cliente) {
		cliente.setDireccion("S/D");
		cliente.setTelefono("S/N");
		return cliente;
	}
	@RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
	public ModelAndView guardarCliente(@ModelAttribute Cliente cliente) {
		
		if(esValida(cliente)) {
			int id = clienteDAO.sigId();
			clienteDAO.save(nuevaCliente(cliente));
		    ModelAndView model = new ModelAndView();
		    System.out.println("mostrarperfil  "+id);
		    
		    model.addObject("id", id);
		    model.setViewName("main");
		    return model;
		}
		ModelAndView model = new ModelAndView();
	    model.setViewName("clienteNoValidaRegistro");
	    return model;
	    
	}
	public boolean esValida(Cliente cliente) {
		
		if(cliente.getId_cliente()!= 0) {
			if(cliente.getTelefono().length() > 8) {
				return false;
			}
		}
		
		List<Cliente> clientes = clienteDAO.list();
		
		
		for(Cliente c : clientes) {
			if(c.getEmail().equals(cliente.getEmail()) && c.getId_cliente()!=cliente.getId_cliente()) {
				return false;
			}
		}
		return true;
		
	}
	@RequestMapping(value = "/actualizarCliente", method = RequestMethod.POST)
	public ModelAndView actualizarCliente(@ModelAttribute Cliente cliente) {
		System.out.println("actualizarCliente -------------------------------"+cliente.toString());
	    if(esValida(cliente)) {
	    	clienteDAO.update(cliente);
		    ModelAndView model = new ModelAndView();
		    model.setViewName("welcome");
		    return model;
	    }
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", cliente.getId_cliente());
	    model.setViewName("clienteNoValida");
	    return model;
	}
	@RequestMapping(value = "/cancelMain", method = RequestMethod.GET)
	public ModelAndView cancelMain(HttpServletRequest request) {
	    int clienteId = Integer.parseInt(request.getParameter("id"));
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", clienteId);
	    model.setViewName("main");
	    return model;
	}
	
	@RequestMapping(value = "/mostrarPerfil", method = RequestMethod.GET)
	public ModelAndView mostrarPerfil(HttpServletRequest request ) {
		HttpSession session = request.getSession();
        System.out.println(session.toString());
		Cliente cliente = new Cliente();
        cliente = (Cliente) session.getAttribute("cliente");
		System.out.println(cliente.toString());
	    ModelAndView model = new ModelAndView("perfil");
	    model.addObject("cliente", cliente);
	 
	    return model;
	}
	
	
}