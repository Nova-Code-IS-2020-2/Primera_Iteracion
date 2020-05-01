package com.deliexpress.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deliexpress.model.Categoria;
import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.http.*;
import com.deliexpress.dao.IniciarSesionDAO;
import com.deliexpress.model.Cliente;
import com.deliexpress.model.Repartidor;
import com.deliexpress.model.Administrador;
import com.deliexpress.model.Carrito;

@Controller
public class IniciarSesion extends HttpServlet{
 
	private static final long serialVersionUID = 1L;
	 
    public IniciarSesion() {
        super();
    }
    
    @RequestMapping("/iniciarSesion")
	public ModelAndView iniciarSesion() {
		return new ModelAndView("iniciarsesion");
	}
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        IniciarSesionDAO isDAO = new IniciarSesionDAO();
        ModelAndView mav = null;
        try {
            Cliente cliente = isDAO.checkLogin(email, password);
            Repartidor rep = isDAO.checkLoginRepartidor(email,password);
            Administrador admin = isDAO.checkLoginAdmin(email,password);
            
            if (cliente != null) {
            	HttpSession session = request.getSession();
                session.setAttribute("cliente", cliente);
            	 mav = new ModelAndView("menucliente");
                
            } else if(admin != null){
            	HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
            	mav = new ModelAndView("principaladmin");
            }else if(rep != null) {
            	HttpSession session = request.getSession();
                session.setAttribute("rep", rep);
                List<String[]> dirs = isDAO.dirIdOrd(); 
                session.setAttribute("dirs",dirs );
            	mav = new ModelAndView("seleccionarcomida");
            }else {
            	String message = "email/contraseña Invalido ";
                request.setAttribute("message", message);
            	mav = new ModelAndView("iniciarsesion");
            }
            
            return mav;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
    
    @RequestMapping(value="/menucliente")
	public ModelAndView menuCliente(ModelAndView model)throws IOException {
		model.setViewName("menucliente");
	    return model;
	}
    
    @RequestMapping(value="/principaladmin")
	public ModelAndView menuAdmin(ModelAndView model)throws IOException {
		model.setViewName("principaladmin");
	    return model;
	}
    
    @RequestMapping(value="/seleccionarcomida")
	public ModelAndView menuRepartidor(ModelAndView model)throws IOException {
		model.setViewName("seleccionarcomida");
	    return model;
	}
}