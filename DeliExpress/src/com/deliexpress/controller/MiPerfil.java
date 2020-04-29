package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.*;
import com.deliexpress.dao.CuentaDAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MiPerfil{
	
	@Autowired
    private CuentaDAO cuentaDAO;
	
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
			int id = cuentaDAO.sigId();
			cuentaDAO.save(nuevaCliente(cliente));
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
	
	public boolean esValidaAdmin(Administrador admin) {
		List<Administrador> admins = cuentaDAO.listAdmin();
		for(Administrador c : admins) {
			if(c.getEmail().equals(admin.getEmail()) && c.getId_admin()!=admin.getId_admin()) {
				return false;
			}
		}
		return true;
	}
	public boolean esValidaRep(Repartidor rep) {
		List<Repartidor> reps = cuentaDAO.listaRep();
		for(Repartidor c : reps) {
			if(c.getEmail().equals(rep.getEmail()) && c.getId_repartidor()!=rep.getId_repartidor()) {
				return false;
			}
		}
		return true;
	}
	
	@RequestMapping(value = "/actualizarCliente", method = RequestMethod.POST)
	public ModelAndView actualizarCliente(@ModelAttribute Cliente cliente) {
		System.out.println("actualizarCliente -------------------------------"+cliente.toString());
	    if(esValida(cliente)) {
	    	cuentaDAO.update(cliente);
		    ModelAndView model = new ModelAndView();
		    model.setViewName("registrarcliente");
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
        Administrador admin = new Administrador();
        Repartidor rep = new Repartidor();
        
        if(session.getAttribute("cliente") != null) {
        	cliente = (Cliente) session.getAttribute("cliente");
        	System.out.println(cliente.toString());
     	    ModelAndView model = new ModelAndView("perfil");
     	    model.addObject("cliente", cliente);
     	    return model;
        }else if(session.getAttribute("admin") != null) {
        	admin = (Administrador) session.getAttribute("admin");
    		System.out.println(admin.toString());
    	    ModelAndView model = new ModelAndView("perfiladmin");
    	    model.addObject("admin", admin);
    	    return model;
        }else {
        	rep = (Repartidor) session.getAttribute("rep");
    		System.out.println(admin.toString());
    	    ModelAndView model = new ModelAndView("perfilrep");
    	    model.addObject("rep", rep);
    	    return model;
        }
	}
	public ModelAndView actualizarAdmin(@ModelAttribute Administrador admin) {
		System.out.println("actualizarCliente -------------------------------"+admin.toString());
	    if(esValidaAdmin(admin)) {
	    	cuentaDAO.update(admin);
		    ModelAndView model = new ModelAndView();
		    model.setViewName("welcome");
		    return model;
	    }
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", admin.getId_admin());
	    model.setViewName("admminNoValida");
	    return model;
	}
	public ModelAndView actualizarRep(@ModelAttribute Repartidor rep) {
		System.out.println("actualizarRep -------------------------------"+rep.toString());
	    if(esValidaRep(rep)) {
	    	cuentaDAO.update(rep);
		    ModelAndView model = new ModelAndView();
		    model.setViewName("welcome");
		    return model;
	    }
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", rep.getId_repartidor() );
	    model.setViewName("RepNoValida");
	    return model;
	}

	@RequestMapping(value = "/crearCliente", method = RequestMethod.POST)
	public ModelAndView crearCliente(@ModelAttribute Cliente cliente,HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("Entro CrearCliente" + cliente.toString());
	    String message = "Email o telefono incorrectos";
        ModelAndView mav = new  ModelAndView("iniciarsesion") ;
        if(esValida(cliente)) {
        	cuentaDAO.save(cliente);
        	return mav;
        }else {
        	mav.setViewName("registrarcliente");
        	request.setAttribute("message", message);
        	return mav;
        }
	}
	
	@RequestMapping(value = "/agregarCliente", method = RequestMethod.GET)
	public ModelAndView agregarCliente(ModelAndView model) {
	    Cliente cliente = new Cliente();
	    model.addObject("cliente", cliente);
	    model.setViewName("registrarcliente");
	    return model;
	}

	public boolean clienteValido(Cliente cliente) {
		return cuentaDAO.checkEmail(cliente.getEmail()) && cuentaDAO.checkTel(cliente.getTelefono());
	}
	
	public boolean esValida(Cliente cliente) {
		if(cliente.getTelefono().length() > 8) {
			return false;
		}
		List<Cliente> clientes = cuentaDAO.list();
		List<Administrador> admins = cuentaDAO.listAdmin();
		List<Repartidor> reps = cuentaDAO.listaRep();
		
		//Verificas que su email no sea el mismo al de algún cliente
		for(Cliente c : clientes) {
			if(c.getEmail().equals(cliente.getEmail()) || c.getTelefono().equals(cliente.getTelefono())) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de algún Admin
		for(Administrador c : admins) {
			if(c.getEmail().equals(cliente.getEmail())) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de algún Repartidor
		for(Repartidor c : reps) {
			if(c.getEmail().equals(cliente.getEmail())) {
				return false;
			}
		}
		return true;
			
		}
	
	
}