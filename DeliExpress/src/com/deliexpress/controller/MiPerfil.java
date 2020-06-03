package com.deliexpress.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.deliexpress.model.*;
import com.deliexpress.dao.CuentaDAO;
import com.deliexpress.dao.IniciarSesionDAO;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MiPerfil{

	@Autowired
    private CuentaDAO cuentaDAO;

	@RequestMapping(value = "/registrate", method = RequestMethod.GET)
	public ModelAndView registrate(ModelAndView model) {
	    Cliente cliente = new Cliente();
	    model.addObject("cliente", cliente);
	    model.setViewName("catform");
	    return model;
	}
	public Cliente nuevaCliente(Cliente cliente) {
		cliente.setDireccion("S/D");
		cliente.setTelefono("S/N");
		return cliente;
	}
	@RequestMapping(value = "/guardarCliente", method = RequestMethod.POST)
	public ModelAndView guardarCliente(@ModelAttribute Cliente cliente) {

		if(esValida(cliente)) {
			int id = cuentaDAO.sigId();
			cuentaDAO.save(nuevaCliente(cliente));
		    ModelAndView model = new ModelAndView();
		    System.out.println("mostrarperfil  "+id);

		    model.addObject("id", id);
		    model.setViewName("main");
		    return model;
		}
		ModelAndView model = new ModelAndView();
	    model.setViewName("clienteNoValidaRegistro");
	    return model;

	}
	public boolean esValida(Cliente cliente) {

		if(cliente.getId_cliente()!= 0) {
			if(cliente.getTelefono().length() > 8) {
				return false;
			}
		}

		List<Cliente> clientes = cuentaDAO.list();
		List<Administrador> admins = cuentaDAO.listAdmin();
		List<Repartidor> reps = cuentaDAO.listaRep();

		//Verificas que su email no sea el mismo al de alg�n cliente
		for(Cliente c : clientes) {
			if(c.getEmail().equals(cliente.getEmail()) && c.getId_cliente()!=cliente.getId_cliente()) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de alg�n Admin
		for(Administrador c : admins) {
			if(c.getEmail().equals(cliente.getEmail())) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de alg�n Repartidor
		for(Repartidor c : reps) {
			if(c.getEmail().equals(cliente.getEmail())) {
				return false;
			}
		}
		return true;

	}
	public boolean esValidaAdmin(Administrador admin) {

		List<Cliente> clientes = cuentaDAO.list();
		List<Administrador> admins = cuentaDAO.listAdmin();
		List<Repartidor> reps = cuentaDAO.listaRep();

		//Verificas que su email no sea el mismo al de alg�n cliente
		for(Cliente c : clientes) {
			if(c.getEmail().equals(admin.getEmail())) {
				return false;
			}
		}
		//Verificas que su email no sea el mismo al de alg�n Admin
		for(Administrador c : admins) {
			if(c.getEmail().equals(admin.getEmail()) && c.getId_admin()!=admin.getId_admin() ) {
				return false;
			}
		}
		//Verificas que su email no sea el mismo al de alg�n Repartidor
		for(Repartidor c : reps) {
			if(c.getEmail().equals(admin.getEmail())) {
				return false;
			}
		}
		return true;

	}
	public boolean esValidaRep(Repartidor rep) {

		List<Cliente> clientes = cuentaDAO.list();
		List<Administrador> admins = cuentaDAO.listAdmin();
		List<Repartidor> reps = cuentaDAO.listaRep();

		//Verificas que su email no sea el mismo al de alg�n cliente
		for(Cliente c : clientes) {
			if(c.getEmail().equals(rep.getEmail())) {
				return false;
			}
		}
		//Verificas que su email no sea el mismo al de alg�n Admin
		for(Administrador c : admins) {
			if(c.getEmail().equals(rep.getEmail()) ) {
				return false;
			}
		}
		//Verificas que su email no sea el mismo al de alg�n Repartidor
		for(Repartidor c : reps) {
			if(c.getEmail().equals(rep.getEmail()) && c.getId_repartidor()!=rep.getId_repartidor()) {
				return false;
			}
		}
		return true;

	}

	@RequestMapping(value = "/actualizarCliente", method = RequestMethod.POST)
	public ModelAndView actualizarCliente(@ModelAttribute Cliente cliente,HttpServletRequest request,HttpServletResponse response) {
		String message = "Email o telefono incorrectos";
		ModelAndView model = new ModelAndView();
		if(esValida(cliente)) {
			HttpSession session = request.getSession();
	    	session.removeAttribute("cliente");
	    	session.setAttribute("cliente", cliente);
		    model.setViewName("menucliente");
		    return model;
	    }
	    model.addObject("id", cliente.getId_cliente());
	    model.setViewName("perfil");
	    request.setAttribute("message", message);
	    return model;
	}

	@RequestMapping(value = "/actualizarRep", method = RequestMethod.POST)
	public ModelAndView actualizarRep(@ModelAttribute Repartidor rep,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("actualizarRep-------------------------------"+rep.toString());
		String message = "Email repetido";
		ModelAndView model = new ModelAndView();
		if(esValidaRep(rep)) {
	    	cuentaDAO.update(rep);
	    	//String email = request.getParameter("email");
	        //String password = request.getParameter("password");
	        //Administrador adminNuevo = isDAO.checkLoginAdmin(email,password);
	    	//model.addObject("admin", adminNuevo);
	    	HttpSession session = request.getSession();
	    	session.removeAttribute("rep");
	    	session.setAttribute("rep", rep);
	    	return new ModelAndView("redirect:/ordenes");
	    }
	    model.addObject("rep", rep);
	    model.setViewName("perfilrep");
	    request.setAttribute("message", message);
	    return model;
	}
	@RequestMapping(value = "/cancelMain", method = RequestMethod.GET)
	public ModelAndView cancelMain(HttpServletRequest request) {
	    int clienteId = Integer.parseInt(request.getParameter("id"));
	    ModelAndView model = new ModelAndView();
	    model.addObject("id", clienteId);
	    model.setViewName("main");
	    return model;
	}

	@RequestMapping(value = "/mostrarPerfil", method = RequestMethod.GET)
	public ModelAndView mostrarPerfil(HttpServletRequest request ) {
		HttpSession session = request.getSession();
        System.out.println(session.toString());
        Cliente cliente = new Cliente();
        Administrador admin = new Administrador();
        Repartidor rep = new Repartidor();

        if(session.getAttribute("cliente") != null) {
        	cliente = (Cliente) session.getAttribute("cliente");
        	System.out.println(cliente.toString());
     	    ModelAndView model = new ModelAndView("perfil");
     	    model.addObject("cliente", cliente);
     	    return model;
        }else if(session.getAttribute("admin") != null) {
        	admin = (Administrador) session.getAttribute("admin");
    		System.out.println(admin.toString());
    	    ModelAndView model = new ModelAndView("perfiladmin");
    	    model.addObject("admin", admin);
    	    return model;
        }else {
        	rep = (Repartidor) session.getAttribute("rep");
    		System.out.println(admin.toString());
    	    ModelAndView model = new ModelAndView("perfilrep");
    	    model.addObject("rep", rep);
    	    return model;
        }
	}

	@RequestMapping(value = "/mostrarPerfilRep", method = RequestMethod.GET)
	public ModelAndView mostrarPerfilRep(HttpServletRequest request ) {
		HttpSession session = request.getSession();
        System.out.println(session.toString());
        Cliente cliente = new Cliente();
        Administrador admin = new Administrador();
        Repartidor rep = new Repartidor();

        if(session.getAttribute("rep") != null) {
        	rep = (Repartidor) session.getAttribute("rep");
    
    	    ModelAndView model = new ModelAndView("perfilrep");
    	    model.addObject("rep", rep);
    	    return model;
        }else {
        	return new ModelAndView("index");
        }
	}
	@RequestMapping(value = "/mostrarPerfilAdmin", method = RequestMethod.GET)
	public ModelAndView mostrarPerfilAdmin(HttpServletRequest request ) {
		HttpSession session = request.getSession();
        System.out.println(session.toString());
        Cliente cliente = new Cliente();
        Administrador admin = new Administrador();
        Repartidor rep = new Repartidor();

        if(session.getAttribute("admin") != null) {
        	admin = (Administrador) session.getAttribute("admin");
    		System.out.println(admin.toString());
    	    ModelAndView model = new ModelAndView("perfiladmin");
    	    model.addObject("admin", admin);
    	    return model;
        }else {
        	return new ModelAndView("index");
        }
	}

	@RequestMapping(value = "/actualizarAdmin", method = RequestMethod.POST)
	public ModelAndView actualizarAdmin(@ModelAttribute Administrador admin,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException {
		System.out.println("actualizarAdmin-------------------------------"+admin.toString());
		String message = "Email repetido";
		ModelAndView model = new ModelAndView();
		if(esValidaAdmin(admin)) {
	    	cuentaDAO.update(admin);
	    	//String email = request.getParameter("email");
	        //String password = request.getParameter("password");
	        //Administrador adminNuevo = isDAO.checkLoginAdmin(email,password);
	    	//model.addObject("admin", adminNuevo);
	    	HttpSession session = request.getSession();
	    	session.removeAttribute("admin");
	    	session.setAttribute("admin", admin);
	    	model.setViewName("redirect:/menuAdmin");
    	    return model;
	    }
	    //model.addObject("admin", admin);
	    model.setViewName("perfiladmin");
	    request.setAttribute("message", message);
	    return model;
	}

	@RequestMapping(value = "/crearCliente", method = RequestMethod.POST)
	public ModelAndView crearCliente(@ModelAttribute Cliente cliente,HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("Entro CrearCliente" + cliente.toString());
	    String message = "Email o telefono incorrectos";
        ModelAndView mav = new  ModelAndView("iniciarsesion") ;
        if(clienteValido(cliente)) {
        	cuentaDAO.save(cliente);
        	
        	EmailSendingServlet ess = new EmailSendingServlet();
			 try{
					ess.registroCliente(cliente.getEmail());
			 } catch (Exception ex) {
					ex.printStackTrace();
			 		String resultMessage = "Hubo un error: " + ex.getMessage();
			 }
        	return mav;
        }else {
        	mav.setViewName("registrarcliente");
        	request.setAttribute("message", message);
        	return mav;
        }
	}

	@RequestMapping(value = "/crearRep", method = RequestMethod.POST)
	public ModelAndView crearRep(@ModelAttribute Repartidor repo,HttpServletRequest request, HttpServletResponse response) {
	    System.out.println("Entro CrearRep" + repo.toString());
	    String message = "Email ya registrado!";
        ModelAndView mav = new  ModelAndView("redirect:/agregarRep") ;
        if(repValido(repo)) {
        	System.out.println("repValidoTrue");
        	cuentaDAO.save(repo);

            EmailSendingServlet ess = new EmailSendingServlet();
			 try{
					ess.registroRepartidor(repo.getEmail());
			 } catch (Exception ex) {
					ex.printStackTrace();
			 		String resultMessage = "There were an error: " + ex.getMessage();
			 }
        	return mav;
        }else {
        	System.out.println("repValidoFalse");
        	Repartidor rep = new Repartidor();
        	mav.addObject("rep", rep);
        	mav.setViewName("registrarep");
        	request.setAttribute("message", message);
        	return mav;
}
	}

	@RequestMapping(value = "/agregarCliente", method = RequestMethod.GET)
	public ModelAndView agregarCliente(ModelAndView model) {
	    Cliente cliente = new Cliente();
	    model.addObject("cliente", cliente);
	    model.setViewName("registrarcliente");
	    return model;
	}

	@RequestMapping(value = "/agregarRep", method = RequestMethod.GET)
	public ModelAndView agregarRep(ModelAndView model) {
	    Repartidor rep = new Repartidor();
	    model.addObject("rep", rep);
	    model.setViewName("registrarep");
	    return model;
	}

	public boolean clienteValido(Cliente cliente) {
		if(cliente.getTelefono().length() > 8) {
			return false;
		}
		List<Cliente> clientes = cuentaDAO.list();
		List<Administrador> admins = cuentaDAO.listAdmin();
		List<Repartidor> reps = cuentaDAO.listaRep();

		//Verificas que su email no sea el mismo al de alg�n cliente
		for(Cliente c : clientes) {
			if(c.getEmail().equals(cliente.getEmail()) || c.getTelefono().equals(cliente.getTelefono())) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de alg�n Admin
		for(Administrador c : admins) {
			if(c.getEmail().equals(cliente.getEmail())) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de alg�n Repartidor
		for(Repartidor c : reps) {
			if(c.getEmail().equals(cliente.getEmail())) {
				return false;
			}
		}
		return true;

		}

	public boolean repValido(Repartidor rep) {
		List<Cliente> clientes = cuentaDAO.list();
		List<Administrador> admins = cuentaDAO.listAdmin();
		List<Repartidor> reps = cuentaDAO.listaRep();

		//Verificas que su email no sea el mismo al de alg�n rep
		for(Cliente c : clientes) {
			if(c.getEmail().equals(rep.getEmail()) ) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de alg�n Admin
		for(Administrador c : admins) {
			if(c.getEmail().equals(rep.getEmail())) {
				return false;
			}
		}
		//Verifica que su email no sea el mismo al de alg�n Repartidor
		for(Repartidor c : reps) {
			if(c.getEmail().equals(rep.getEmail())) {
				return false;
			}
		}
		return true;

		}



}
