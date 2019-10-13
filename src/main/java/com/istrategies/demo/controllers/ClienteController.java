package com.istrategies.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.istrategies.demo.models.dao.IClienteDao;
import com.istrategies.demo.models.entity.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDao clienteDao;
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute ("titulo","Listado de Cliente");
		model.addAttribute ("clientes",clienteDao.findAll());
		return "listar";
		
		
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "formulario de cliente");
		
		
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid  Cliente cliente, BindingResult result,	Model model ) {
		if(result.hasErrors()) {
		
			model.addAttribute("titulo", "formulario de cliente");
			
			return "form";
		}
		
		clienteDao.save(cliente);
		
		return "redirect:listar";
		
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Integer id, Map<String, Object>model, RedirectAttributes flash) {
	Optional<Cliente> cliente = null;
	if(id>0) {
		cliente = clienteDao.findById(id);
		if (cliente==null) {
		flash.addFlashAttribute("error", "Error el id no existe" );
		return "redirect:/listar";
		}
	}else {
		
		flash.addFlashAttribute("error ", "El id no puede ser cero" );
		return "redirect:/listar";
	}
	model.put("cliente", cliente);
	model.put("titulo", "formulario de cliente");
	
		return "form";
		
	}
	/*
@RequestMapping(value="/form", method= RequestMethod.POST)
public String guardar(@Valid  Cliente cliente, BindingResult result , Model model) {
	
	return "listar";
}
	
	*/
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") int id) {
		if(id>0) {
		clienteDao.deleteById(id);	
		}
		

		return "redirect:/listar";
		
	}
}
