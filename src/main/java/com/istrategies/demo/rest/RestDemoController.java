package com.istrategies.demo.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.istrategies.demo.models.dao.IClienteDao;
import com.istrategies.demo.models.entity.Cliente;

@RestController
@RequestMapping("/Cliente")
@SessionAttributes("clientes")
public class RestDemoController {
	
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping
	public List<Cliente> listar(){
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void insertar(@RequestBody Cliente cliente, SessionStatus status){
		clienteDao.save(cliente);
		status.setComplete();
	}
	 
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void update(@RequestBody Cliente cliente, SessionStatus status){
		clienteDao.save(cliente);
		status.setComplete();
	}
	
	
	
	@DeleteMapping(value="{id}")
	public void eliminar(@PathVariable("id") int id,SessionStatus status){
		clienteDao.deleteById(id);
		status.setComplete();
	}

}
