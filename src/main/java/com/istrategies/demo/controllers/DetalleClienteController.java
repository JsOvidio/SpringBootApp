package com.istrategies.demo.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.istrategies.demo.models.dao.IClienteDao;
import com.istrategies.demo.models.dao.IDetalleClienteDao;
import com.istrategies.demo.models.entity.DetalleCliente;

@Controller
public class DetalleClienteController {
	

	
	// Se utiliza para mostrar log en consola 
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IDetalleClienteDao detalleclienteDao;
	
	@RequestMapping(value="/formdetallecliente", method=RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		DetalleCliente detallecliente = new DetalleCliente();
		model.put("detallecliente", detallecliente);
		model.put("titulo", "formulario de cliente");
		
		
		return "formdetallecliente";
	}
	
	@RequestMapping(value="/formdetallecliente", method=RequestMethod.POST)
	public String guardar(@Valid  DetalleCliente detallecliente, BindingResult result,	Model model ) {
		if(result.hasErrors()) {
		
			model.addAttribute("titulo", "formulario de cliente");
			
			return "formdetallecliente";
		}
		
		detalleclienteDao.save(detallecliente);
		
		return "redirect:listar";
		
	}
	
	/*
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute ("titulo","Listado de Cliente");
		model.addAttribute ("clientes",detalleclienteDao.findAll());
		return "listar";
		
		
	}
	
	
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid  DetalleCliente detallecliente, BindingResult result,	Model model ) {
		if(result.hasErrors()) {
		
			model.addAttribute("titulo", "formulario de cliente");
			
			return "form";
		}
		
		detalleclienteDao.save(detallecliente);
		
		return "redirect:listar";
		
	}
	
	@RequestMapping(value="/formdetallecliente/{id}")
	public String editar(@PathVariable(value="id") Integer id, Map<String, Object>model, RedirectAttributes flash) {
	Optional<DetalleCliente> detallecliente = null;
	if(id>0) {
		detallecliente = detalleclienteDao.findById(id);
		if (detallecliente==null) {
		flash.addFlashAttribute("error", "Error el id no existe" );
		return "redirect:/listar";
		}
	}else {
		
		flash.addFlashAttribute("error ", "El id no puede ser cero" );
		return "redirect:/listar";
	}
	log.info("id a modificar:" +  id);
	model.put("detallecliente", detallecliente);
	model.put("titulo", "formulario de detalle de cliente");
	
		return "form";
		
	}
	
@RequestMapping(value="/form", method= RequestMethod.POST)
public String guardar(@Valid  Cliente cliente, BindingResult result , Model model) {
	
	return "listar";
}
	
	
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") int id) {
		if(id>0) {
			detalleclienteDao.deleteById(id);	
		}
		//forma correcta de mostrar log
		log.info("id a eliminar:" +  id);

		return "redirect:/listar";
		
	}
	
	@RequestMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Integer id, Map<String, Object>model, RedirectAttributes flash) {
	Optional<Cliente> cliente = null;
	if(id>0) {
		cliente = detalleclienteDao.findById(id);
		if (cliente==null) {
		flash.addFlashAttribute("error", "Error el id no existe" );
		return "redirect:/listar";
		}
	}else {
		
		flash.addFlashAttribute("error ", "El id no puede ser cero" );
		return "redirect:/listar" ;
	}
	
	model.put("cliente", cliente);
	System.out.println("clientecontroller"+ cliente);
	model.put("titulo", "formulario d");
	
	return "ver" ;
		
	}
*/
}
