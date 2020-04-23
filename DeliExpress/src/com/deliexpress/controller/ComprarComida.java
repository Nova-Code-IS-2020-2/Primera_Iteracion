package com.deliexpress.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.dao.OrdenDAO;
@Controller 
public class ComprarComida {
	@Autowired
	private OrdenDAO ordenDAO; 
	//solo es poner como listo el estado de la orden 
	@RequestMapping(value = "/comprarComida", method = RequestMethod.GET)
	public ModelAndView comprarComida(HttpServletRequest request) {
	   //poner la orden en proceso y mostrarle una pantalla al repartidor de que se tiene que 
		//dirigir a tal lado 
	    int idOrden = Integer.parseInt(request.getParameter("idOrden"));
	    ordenDAO.asignarEstadoListo(idOrden); 
	    ModelAndView model = new ModelAndView(); 
	    //redirecciona a la pagina prncipal por ahora hasta que se integre todo 
	    model.setViewName("welcome");
	    return model; 
	}
}
