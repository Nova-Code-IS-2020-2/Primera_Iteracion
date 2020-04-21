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
  
    @RequestMapping("/home")
   	public ModelAndView home() {
   		return new ModelAndView("home");
   	}
    
   
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         
        IniciarSesionDAO isDAO = new IniciarSesionDAO();
        ModelAndView mav = null;
        try {
            Cliente user = isDAO.checkLogin(email, password);
            if (user != null) {
            	 mav = new ModelAndView("home");
                
            } else {
            	mav = new ModelAndView("iniciarsesion");
            }
            return mav;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}