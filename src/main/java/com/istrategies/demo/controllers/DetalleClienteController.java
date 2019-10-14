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

	@RequestMapping(value = "/formdetallecliente", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		DetalleCliente detallecliente = new DetalleCliente();
		model.put("detallecliente", detallecliente);
		model.put("titulo", "formulario detalle de cliente");

		return "formdetallecliente";
	}

	

	@RequestMapping(value="/formdetallecliente", method=RequestMethod.POST)
	  public String guardar(@Valid DetalleCliente detallecliente, BindingResult
	  result, Model model ) { 
		
		if(result.hasErrors()) {
	 
	 model.addAttribute("titulo", "formulario de cliente");
	 
	  return "formdetallecliente"; 
	  
	  }
	 
	  detalleclienteDao.save(detallecliente);
	  
	  return "redirect:listar";
	  
	  }
	

}
