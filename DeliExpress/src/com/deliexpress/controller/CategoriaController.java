package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.beans.Categoria;
import com.deliexpress.dao.CategoriaDAO;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
@Controller
public class CategoriaController{
	
	@Autowired
    private CategoriaDAO categoriaDAO;
	
	@RequestMapping("/principalAdmin")
	public ModelAndView principalAdmin() {
		return new ModelAndView();
	}
 
	@RequestMapping(value="/menuAdmin")
	public ModelAndView listaCategoria(ModelAndView model) throws IOException{
	    List<Categoria> listCat = categoriaDAO.list();
	    model.addObject("listCat", listCat);
	    model.setViewName("menuAdmin");
	 
	    return model;
	}
	@RequestMapping(value = "/agregarCategoria", method = RequestMethod.GET)
	public ModelAndView agregarCategoria(ModelAndView model) {
	    Categoria categoria = new Categoria();
	    model.addObject("categoria", categoria);
	    model.setViewName("catform");
	    return model;
	}
	@RequestMapping(value = "/guardarCategoria", method = RequestMethod.POST)
	public ModelAndView guardarCategoria(@ModelAttribute Categoria categoria) {
	    categoriaDAO.save(categoria);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	@RequestMapping(value = "/actualizarCategoria", method = RequestMethod.POST)
	public ModelAndView actualizarCategoria(@ModelAttribute Categoria categoria) {
	    categoriaDAO.update(categoria);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	
	@RequestMapping(value = "/borrarCategoria", method = RequestMethod.GET)
	public ModelAndView borrarCategoria(HttpServletRequest request) {
	    int catId = Integer.parseInt(request.getParameter("id"));
	    categoriaDAO.delete(catId);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	
	@RequestMapping(value = "/editarCategoria", method = RequestMethod.GET)
	public ModelAndView editarCategoria(HttpServletRequest request) {
	    int catId = Integer.parseInt(request.getParameter("id"));
	    Categoria categoria = categoriaDAO.get(catId);
	    ModelAndView model = new ModelAndView("cateditform");
	    model.addObject("categoria", categoria);
	 
	    return model;
	}
	
	
}

=======
package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.Categoria;
import com.deliexpress.dao.CategoriaDAO;

import java.util.List; 
import java.io.*;
@Controller
public class CategoriaController{
	
	@Autowired
    private CategoriaDAO categoriaDAO;
 
	@RequestMapping(value="/menuAdmin")
	public ModelAndView listaCategoria(ModelAndView model) throws IOException{
	    List<Categoria> listCat = categoriaDAO.list();
	    model.addObject("listCat", listCat);
	    model.setViewName("menuAdmin");
	 
	    return model;
	}
	@RequestMapping(value = "/agregarCategoria", method = RequestMethod.GET)
	public ModelAndView agregarCategoria(ModelAndView model) {
	    Categoria categoria = new Categoria();
	    model.addObject("categoria", categoria);
	    model.setViewName("catform");
	    return model;
	}
	@RequestMapping(value = "/guardarCategoria", method = RequestMethod.POST)
	public ModelAndView guardarCategoria(@ModelAttribute Categoria categoria) {
	    categoriaDAO.save(categoria);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	
	
}