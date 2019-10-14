package com.istrategies.demo.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String apellido;
	@NotEmpty
	@Email
	private String email;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleCliente> detalleclientes;

	public Cliente() {
		detalleclientes = new ArrayList<DetalleCliente>();
	}

	public void addDetalleCliente(DetalleCliente detallecliente) {
		detalleclientes.add(detallecliente);
	}

	public List<DetalleCliente> getDetalleclientes() {
		return detalleclientes;
	}

	public void setDetalleclientes(List<DetalleCliente> detalleclientes) {
		this.detalleclientes = detalleclientes;
	}

}
