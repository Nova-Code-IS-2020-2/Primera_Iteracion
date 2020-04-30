package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.beans.Alimento;
import com.deliexpress.dao.AlimentoDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AlimentoControlador {
	

	@Autowired
    private AlimentoDAO alimentoDAO;
	
	@RequestMapping("/principalAdmin")
	public ModelAndView principalAdmin() {
		return new ModelAndView();
	}
 
	@RequestMapping(value="/menuAdmin")
	public ModelAndView listaAlimento(ModelAndView model) throws IOException{
	    List<Alimento> listAlim = alimentoDAO.list();
	    model.addObject("listAlim", listAlim);
	    model.setViewName("menuAdmin");
	 
	    return model;
	}
	@RequestMapping(value = "/agregarAlimento", method = RequestMethod.GET)
	public ModelAndView agregarAlimento(ModelAndView model) {
	    Alimento alimento = new Alimento();
	    model.addObject("alimento", alimento);
	    model.setViewName("agregarAlimento");
	    return model;
	}
	@RequestMapping(value = "/guardarAlimento", method = RequestMethod.POST)
	public ModelAndView guardarAlimento(@ModelAttribute Alimento alimento) {
	    alimentoDAO.save(alimento);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	@RequestMapping(value = "/actualizarAlimento", method = RequestMethod.POST)
	public ModelAndView actualizarAlimento(@ModelAttribute Alimento alimento) {
	    alimentoDAO.update(alimento);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	
	@RequestMapping(value = "/borrarAlimento", method = RequestMethod.GET)
	public ModelAndView borrarCategoria(HttpServletRequest request) {
	    int alimId = Integer.parseInt(request.getParameter("id"));
	    alimentoDAO.delete(alimId);
	    return new ModelAndView("redirect:/menuAdmin");
	}
	
	@RequestMapping(value = "/editarAlimento", method = RequestMethod.GET)
	public ModelAndView editarAlimento(HttpServletRequest request) {
	    int alimId = Integer.parseInt(request.getParameter("id"));
	    Alimento alimento = alimentoDAO.get(alimId);
	    ModelAndView model = new ModelAndView("actualizarAlimento");
	    model.addObject("alimento", alimento);
	 
	    return model;
	}
}