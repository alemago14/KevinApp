package com.cyseg.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyseg.entidades.Estado;
import com.cyseg.repositorios.EstadoRepositorio;

@Service
public class EstadoServicio {
	
	@Autowired
	private EstadoRepositorio estadoRepo;
	
	//metodo para guardar un nuevo estado en la base de datos
	public void crearEstado(String estado) throws Exception {
		Estado nEstado = new Estado();
		validarEstado(estado);
		
		//comparamos si el estado ya existe en la base de datos
		Optional<Estado> resp = estadoRepo.buscarPorEstadoOp(estado);
		if(resp.isPresent()) {
			throw new Exception("Ya existe en la base de datos");
		}else {
			//si no existe en la base de datos setea el valor del objeto y lo guarda en la base de datos
			nEstado.setEstado(estado);
			estadoRepo.save(nEstado);
		}
	}
	
	//metodo para eliminar un estado en la base de datos
	public void eliminarEstado(String estado) throws Exception {
		//creamos un objeto vacio de estado
		Estado nEstado = new Estado();
		
		//comprobamos que la variable no este vacia
		validarEstado(estado);
		
		Optional<Estado> resp = estadoRepo.buscarPorEstadoOp(estado);
		//buscamos si ya existe en la base de datos
		if(resp.isPresent()) {
			//si existe llenamos el objeto con el resultado de la busqueda
			nEstado = resp.get();
			//elinamos el objeto de la base de datos
			estadoRepo.delete(nEstado);
		}else {
			//si no existe tiramos un error 
			throw new Exception("No existe en la base de datos.");
		}
	}
	
	//metodo para comprobar si se ingreso un valor o la variable esta vacia
	public void validarEstado(String estado) throws Exception {
		if(estado.isEmpty() || estado == null) {
			throw new Exception("El campo esta vacio");
	}
	}}

