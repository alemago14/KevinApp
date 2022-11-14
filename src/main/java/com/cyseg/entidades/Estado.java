package com.cyseg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="estado")
public class Estado {
	
	@Id
	@GeneratedValue(generator ="uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String estado;
	
	
	//constructores
	public Estado(String id, String estado) {
		this.id = id;
		this.estado = estado;
	}
	
	public Estado() {
	}

	//getters y setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
