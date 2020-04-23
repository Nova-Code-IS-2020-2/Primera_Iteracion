package com.deliexpress.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.beans.Alimento;
import com.deliexpress.dao.OrdenDAO;
@Controller
public class SeleccionarOrden {
	@Autowired 
	private OrdenDAO ordenDAO; 
	@RequestMapping(value = "/seleccionarOrden", method = RequestMethod.GET)
	public ModelAndView seleccionarOrden(HttpServletRequest request) {
	   //poner la orden en proceso y mostrarle una pantalla al repartidor de que se tiene que 
		//dirigir a tal lado 
	    String direc = request.getParameter("direc");
	    int idOrden = Integer.parseInt(request.getParameter("idOrden"));
	    int idRep = Integer.parseInt(request.getParameter("idRep"));
	    ordenDAO.asignarRepartidor(idRep, idOrden); 
	    ModelAndView model = new ModelAndView();
	    model.addObject("direc",direc); 
	    //esta vista es mientras se integra todo 
	    model.setViewName("dirigirseA");
	    return model; 

	}
}
