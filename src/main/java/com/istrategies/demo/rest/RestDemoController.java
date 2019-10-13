package com.istrategies.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.istrategies.demo.models.dao.IClienteDao;
import com.istrategies.demo.models.entity.Cliente;

@RestController
@RequestMapping("/clientes/")
public class RestDemoController {
	
	
	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping
	public List<Cliente> listar(){
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody Cliente cliente){
		clienteDao.save(cliente);
	}
	
	@PutMapping
	public void update(@RequestBody Cliente cliente){
		clienteDao.save(cliente);
	}
	
	@DeleteMapping(value="{id}")
	public void eliminar(@PathVariable("id") int id){
		clienteDao.deleteById(id);
	}

}
