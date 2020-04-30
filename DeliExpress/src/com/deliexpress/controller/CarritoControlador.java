package com.deliexpress.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.Carrito;
import com.deliexpress.dao.CarritoDao;

@Controller
public class CarritoControlador {
	
	@Autowired
	private CarritoDao carritoDAO;
	
	@RequestMapping(value="/carrito")
		public ModelAndView listaCarrito(ModelAndView model)throws IOException {
			List<Carrito> listaCarrito = carritoDAO.muestraCarrito();
		    model.addObject("listaCarrito", listaCarrito);	
			model.setViewName("carrito");
		    return model;
		}
	
	@RequestMapping(value="/disminuir", method = RequestMethod.GET)
	public ModelAndView disminuir(HttpServletRequest request)throws IOException {
		String nom = request.getParameter("nom");
		System.out.println("DISMININUIR EN " + nom);
		carritoDAO.disminuir(1,nom);
		return new ModelAndView("redirect:/carrito");
	}
	
	@RequestMapping(value="/aumentar", method = RequestMethod.GET)
	public ModelAndView aumentar(HttpServletRequest request)throws IOException {
		String nom = request.getParameter("nom");
		System.out.println("AUMENTAR EN " + nom);
		//carritoDAO.aumentar(id_orden,nom);
		carritoDAO.aumentar(1,nom);
		return new ModelAndView("redirect:/carrito");
	}
	
}
