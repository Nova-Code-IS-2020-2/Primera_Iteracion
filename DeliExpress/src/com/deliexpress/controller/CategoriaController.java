package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.beans.Cuenta;
import com.deliexpress.dao.CuentaDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CategoriaController{
	
	@Autowired
    private CuentaDAO cuentaDAO;
 
	@RequestMapping(value = "/registrate", method = RequestMethod.GET)
	public ModelAndView registrate(ModelAndView model) {
	    Cuenta cuenta = new Cuenta();
	    model.addObject("cuenta", cuenta);
	    model.setViewName("catform");
	    return model;
	}
	public Cuenta nuevaCuenta(Cuenta cuenta) {
		cuenta.setDireccion("S/D");
		cuenta.setTelefono("S/N");
		return cuenta;
	}
	@RequestMapping(value = "/guardarCuenta", method = RequestMethod.POST)
	public ModelAndView guardarCuenta(@ModelAttribute Cuenta cuenta) {
		
		if(esValida(cuenta)) {
			int id = cuentaDAO.sigId();
			cuentaDAO.save(nuevaCuenta(cuenta));
		    ModelAndView model = new ModelAndView();
		    System.out.println("mostrarperfil  "+id);
		    
		    model.addObject("id", id);
		    model.setViewName("main");
		    return model;
		}
		ModelAndView model = new ModelAndView();
	    model.setViewName("cuentaNoValidaRegistro");
	    return model;
	    
	}
	public boolean esValida(Cuenta cuenta) {
		
		if(cuenta.getId()!= 0) {
			if(cuenta.getTelefono().length() > 8) {
				return false;
			}
		}
		
		List<Cuenta> cuentas = cuentaDAO.list();
		
		
		for(Cuenta c : cuentas) {
			if(c.getEmail().equals(cuenta.getEmail()) && c.getId()!=cuenta.getId()) {
				return false;
			}
		}
		return true;
		
	}
	@RequestMapping(value = "/actualizarCuenta", method = RequestMethod.POST)
	public ModelAndView actualizarCuenta(@ModelAttribute Cuenta cuenta) {
		
	    if(esValida(cuenta)) {
	    	cuentaDAO.update(cuenta);
		    ModelAndView model = new ModelAndView();
		    model.setViewName("welcome");
		    return model;
	    }
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", cuenta.getId());
	    model.setViewName("cuentaNoValida");
	    return model;
	}
	@RequestMapping(value = "/cancelMain", method = RequestMethod.GET)
	public ModelAndView cancelMain(HttpServletRequest request) {
	    int cuentaId = Integer.parseInt(request.getParameter("id"));
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", cuentaId);
	    model.setViewName("main");
	    return model;
	}
	
	@RequestMapping(value = "/mostrarPerfil", method = RequestMethod.GET)
	public ModelAndView mostrarPerfil(HttpServletRequest request) {
	    int cuentaId = Integer.parseInt(request.getParameter("id"));
	    System.out.println("mostrarperfil  "+cuentaId);
	    Cuenta cuenta = cuentaDAO.get(cuentaId);
	    ModelAndView model = new ModelAndView("perfil");
	    model.addObject("cuenta", cuenta);
	 
	    return model;
	}
	
	
}

