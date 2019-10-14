package com.istrategies.demo.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istrategies.demo.models.entity.Cliente;
import com.istrategies.demo.models.entity.DetalleCliente;

public interface IDetalleClienteDao extends  JpaRepository<DetalleCliente, Integer> {

}
