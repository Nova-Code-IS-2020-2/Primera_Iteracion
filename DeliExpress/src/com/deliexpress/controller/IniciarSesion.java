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
import com.deliexpress.beans.Cliente;
import com.deliexpress.beans.Credenciales;
import com.deliexpress.beans.Orden;
import com.deliexpress.beans.Repartidor;
import com.deliexpress.dao.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
@Controller
public class IniciarSesion {
	@Autowired
	private RepartidorDAO repartidorDAO; 
	@Autowired
	private OrdenDAO ordenDAO; 
	@Autowired
	private ClienteDAO clienteDAO; 
	@Autowired 
	private AlimentoDAO alimentoDAO; 
	//va a ser llamado cuando se presione el login 
	@RequestMapping(value = "/iniciarSesion", method = RequestMethod.POST)
	public ModelAndView iniciarSesion(@ModelAttribute Credenciales credenciales,
										@ModelAttribute("carrito") Orden carrito) {
		//tengo los strings 
		System.out.println("las credenciales son " + credenciales.getTipoUsuario()); 
		if(credenciales.getTipoUsuario() == 1) {
			ModelAndView model = new ModelAndView(); 
			System.out.println("la contrasena es " + credenciales.getContr());
			Repartidor rep = repartidorDAO.getWithContr(credenciales.getContr()); 
			System.out.println("el repartidor tiene el id " + rep.getNombre()); 
			//son las direcciones y los identificadores de la orden 
			List<String[]> did = ordenDAO.dirIdOrd();
			model.addObject("rep",rep); 
			model.addObject("did", did);
			model.setViewName("seleccionarOrdenIH");
			return model;
		}else {
			ModelAndView model = new ModelAndView();  
			Orden orden = new Orden();
			Cliente cln = clienteDAO.getWithContr(credenciales.getContr()); 
			orden.setIdCliente(cln.getId());
			//tenemos que pasar las 3 cosas , el cliente , el id donde se va a meter la orden , y la lista de 
			//alimentos 
			int sigId = ordenDAO.sigId();  
			orden.setIdOrden(sigId);
			ordenDAO.ordenInicial(orden); 
			List<Alimento> alims = alimentoDAO.list();
			//agregamos los objetos 
			model.addObject("idCliente",cln.getId()); 
			model.addObject("idOrden",sigId); 
			model.addObject("alims",alims);
			model.setViewName("RUD_CarritoIH"); 
			return model; 
		}
	}
	@RequestMapping(value = "/iniciarSesionIH", method = RequestMethod.GET)
	public ModelAndView iniciarSesionIH(HttpServletRequest request) {
		//va a depender del tipo de usuario 
		Credenciales cr = new Credenciales(); 
		cr.setTipoUsuario(Integer.parseInt(request.getParameter("tipo")));
		ModelAndView model = new ModelAndView(); 
		System.out.println(cr.getTipoUsuario()); 
		model.addObject("creden",cr); 
	    model.setViewName("iniciarSesionIH");
	    return model;
	}
	
	
}
