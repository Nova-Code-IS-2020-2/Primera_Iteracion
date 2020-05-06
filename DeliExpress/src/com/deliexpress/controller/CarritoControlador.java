package com.deliexpress.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.Alimento;
import com.deliexpress.model.Carrito;
import com.deliexpress.model.Cliente;
import com.deliexpress.model.Repartidor;
import com.deliexpress.dao.AlimentoDAO;
import com.deliexpress.dao.CarritoDao;
import com.deliexpress.dao.OrdenDAO;

@Controller
public class CarritoControlador {
	
	@Autowired
	private CarritoDao carritoDAO;
	@Autowired 
	private AlimentoDAO alimentoDAO; 
	@Autowired 
	private OrdenDAO ordenDAO; 
	
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
		HttpSession s = request.getSession(); 
		Carrito carrito = (Carrito)s.getAttribute("carrito");
		carrito.getAlimentos().clear();
		carrito.setPrecio(0);
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
	
	@RequestMapping(value="/aumentarCarrito", method = RequestMethod.GET)
	public ModelAndView aumentarCarrito(HttpServletRequest request)throws IOException {
		 int idAlim = Integer.parseInt(request.getParameter("id_alim"));
		HttpSession s = request.getSession(); 
		Carrito carrito = (Carrito)s.getAttribute("carrito"); 
		Alimento a = alimentoDAO.get(idAlim);
		carrito.setPrecio(carrito.getPrecio()+a.getPrecio());
		System.out.println("el numero es " + carrito.getAlimentos().get(a)); 
		carrito.getAlimentos().put(a, carrito.getAlimentos().get(a)+1); 
		return new ModelAndView("redirect:/carrito");
	}
	@RequestMapping(value="/disminuirCarrito", method = RequestMethod.GET)
	public ModelAndView disminuirCarrito(HttpServletRequest request)throws IOException {
		 int idAlim = Integer.parseInt(request.getParameter("id_alim"));
		HttpSession s = request.getSession(); 
		Carrito carrito = (Carrito)s.getAttribute("carrito"); 
		Alimento a = alimentoDAO.get(idAlim);
		carrito.setPrecio(carrito.getPrecio()-a.getPrecio());
		System.out.println("el numero es " + carrito.getAlimentos().get(a)); 
		carrito.getAlimentos().put(a, carrito.getAlimentos().get(a)-1); 
		return new ModelAndView("redirect:/carrito");
	}
	
	
	@RequestMapping(value="/agregarCarrito", method = RequestMethod.GET)
	public ModelAndView agregarCarrito(HttpServletRequest request)throws IOException {
		 int idAlim = Integer.parseInt(request.getParameter("id_alim"));
		  HttpSession s = request.getSession();
		  Carrito carrito = (Carrito) s.getAttribute("carrito");
		  Alimento a = alimentoDAO.get(idAlim); 
		  carrito.setPrecio(carrito.getPrecio()+a.getPrecio());
		  carrito.getAlimentos().put(a,1); 
		  System.out.println(alimentoDAO.get(idAlim).getPrecio());
		  System.out.println("el carrito tiene " + carrito.alimentos.size()); 
		  ModelAndView mav = new ModelAndView("menucliente");
		  return mav; 
	}
	@RequestMapping(value="/verCarrito", method = RequestMethod.GET)
	public ModelAndView verCarrito(HttpServletRequest request)throws IOException {
		  ModelAndView mav = new ModelAndView("verCarritoIH");
		  return mav; 
	}
	@RequestMapping(value="/eliminarCarrito",method=RequestMethod.GET)
	public ModelAndView eliminarCarrito(HttpServletRequest request){
		int idAlim = Integer.parseInt(request.getParameter("id_alim")); 
		HttpSession s = request.getSession(); 
		Carrito carrito = (Carrito) s.getAttribute("carrito"); 
		//eliminar del carrito 
		Alimento a = alimentoDAO.get(idAlim);
		carrito.setPrecio(carrito.getPrecio()-carrito.getAlimentos().get(a)*a.getPrecio());
		carrito.getAlimentos().remove(a);
		ModelAndView mav = new ModelAndView("redirect:/carrito"); 
		return mav; 
	}
	@RequestMapping(value="/comprarComida",method=RequestMethod.GET)
	public ModelAndView comprarComida(HttpServletRequest request){ 
		HttpSession s = request.getSession(); 
		Carrito carrito = (Carrito) s.getAttribute("carrito");
		//eliminar del carrito 
		ordenDAO.guardarOrden(carrito, ((Cliente)s.getAttribute("cliente")).getId_cliente());
		carrito.getAlimentos().clear();
		carrito.setPrecio(0);
		return new ModelAndView("menucliente");
	}
}
