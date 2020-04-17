package com.deliexpress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List; 
import java.io.*;

@Controller
public class ISController{
	
	@Autowired
    /*private CategoriaDAO categoriaDAO;*/
 
	@RequestMapping(value = "/iniciarSesion")
	public ModelAndView iniciarSesion(ModelAndView model) {
	    model.setViewName("iniciarsesion");
	    return model;
	}

	
}