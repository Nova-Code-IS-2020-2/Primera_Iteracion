package com.deliexpress.controller;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import com.deliexpress.beans.Categoria;
import com.deliexpress.dao.CatDao;

public class CategoriaController {
	
	CatDao dao;
	
	/*Muestra un formulario para introducir informacion,"command" es un atributo de solicitud  
    * reservado que se se usa para mostrar la información del objeto en un formulario  
    */   
	@RequestMapping("/catform")
	public String showForm(Model m) {
		m.addAttribute("command", new Categoria());  
        return "catform";   
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("cat") Categoria categoria){    
        dao.save(categoria);    
        return "redirect:/leerMenuAdmin";//will redirect to viewcat request mapping    
    }   
	
	 /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    @RequestMapping(value="/editcat/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Categoria cat=dao.getCatById(id);    
        m.addAttribute("command",cat);  
        return "cateditform";    
    }    
    /* It updates model object. */    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("cat") Categoria cat){    
        dao.update(cat);    
        return "redirect:/leerMenuAdmin";    
    }    
    /* It deletes record for the given id in URL and redirects to /viewcat */    
    @RequestMapping(value="/deletecat/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/leerMenuAdmin";    
    }     
	
}
