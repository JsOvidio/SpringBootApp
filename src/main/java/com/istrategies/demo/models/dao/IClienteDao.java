package com.istrategies.demo.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.istrategies.demo.models.entity.Cliente;

public interface IClienteDao  extends  CrudRepository<Cliente, Integer>{

	
}
