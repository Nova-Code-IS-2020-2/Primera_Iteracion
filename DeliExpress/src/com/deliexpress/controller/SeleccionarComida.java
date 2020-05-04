package com.deliexpress.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.dao.OrdenDAO;
import com.deliexpress.model.Repartidor;

@Controller
public class SeleccionarComida {
		@Autowired 
		OrdenDAO ordenDAO; 
	  @RequestMapping(value = "/seleccionarComida", method = RequestMethod.GET)
	    public ModelAndView seleccionarComida(HttpServletRequest request){
		  int idOrd = Integer.parseInt(request.getParameter("id_orden"));
		  HttpSession s = request.getSession();
		  Repartidor r = (Repartidor) s.getAttribute("rep"); 
		  System.out.println("el id del repartidor es " + r.getId_repartidor());
		  //se deberia guardar el id del repartidor en la orden que escogio
		  ordenDAO.updateRepartidor(idOrd, r.getId_repartidor()); 
		  ModelAndView mav = new ModelAndView("seleccionarcomida");
		  return mav; 
	  }
}
