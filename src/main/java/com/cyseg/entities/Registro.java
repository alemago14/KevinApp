package com.cyseg.entities;

import javax.persistence.Entity;

import com.cyseg.enums.Estado;

@Entity
public class Registro {

	//atributos
	private Long id;
	private String enlace;
	private Estado estado;

	//constructores
	public Registro(Long id, String enlace, Estado estado) {
		this.id = id;
		this.enlace = enlace;
		this.estado = estado;
	}
	
	public Registro() {
	}
	
	//getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
