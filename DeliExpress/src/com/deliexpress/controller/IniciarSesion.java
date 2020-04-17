package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
 
@Controller
public class IniciarSesion{
 
	@RequestMapping("/iniciarSesion")
	public ModelAndView iniciarSesion() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "This message is coming from IniciarSesion.java </div><br><br>";
		return new ModelAndView("iniciarsesion", "message", message);
	}
}