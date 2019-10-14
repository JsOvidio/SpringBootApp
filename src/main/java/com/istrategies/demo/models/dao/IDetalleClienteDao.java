package com.istrategies.demo.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istrategies.demo.models.entity.DetalleCliente;

public interface IDetalleClienteDao extends  JpaRepository<DetalleCliente, Integer> {

	

	
	//List<DetalleCliente> findAllByIdC(int ids);
}
