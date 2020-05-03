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
		public ModelAndView listaCarrito(ModelAndView model,HttpServletRequest request)throws IOException {
			float precioTotal = 0;
			//Cambiar por id de carrito
			precioTotal = carritoDAO.precioTotal(1);
			String precioSalida = precioTotal + "mxn";
			System.out.println(precioSalida);
			List<Carrito> listaCarrito = carritoDAO.muestraCarrito();
			
			model.addObject("listaCarrito", listaCarrito);	
		    model.addObject("precio", precioSalida);
		    model.setViewName("carrito");
		    return model;
		}
	
	@RequestMapping(value="/vaciarCarrito")
	public ModelAndView vaciarCarrito(ModelAndView model,HttpServletRequest request)throws IOException {
		float precioTotal = 0;
		//cambiar por id orden
		carritoDAO.vaciarCarrito(1);
		return new ModelAndView("redirect:/carrito");
	}
	
	@RequestMapping(value="/disminuir", method = RequestMethod.GET)
	public ModelAndView disminuir(HttpServletRequest request)throws IOException {
		String nom = request.getParameter("nom");
		System.out.println("DISMININUIR EN " + nom);
		//cambiar por id orden
		carritoDAO.disminuir(1,nom);
		return new ModelAndView("redirect:/carrito");
	}
	
	@RequestMapping(value="/aumentar", method = RequestMethod.GET)
	public ModelAndView aumentar(HttpServletRequest request)throws IOException {
		String nom = request.getParameter("nom");
		System.out.println("AUMENTAR EN " + nom);
		//cambiar por id orden
		carritoDAO.aumentar(1,nom);
		return new ModelAndView("redirect:/carrito");
	}
}
