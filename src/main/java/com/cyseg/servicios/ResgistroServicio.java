package com.cyseg.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyseg.entidades.Estado;
import com.cyseg.entidades.Registro;
import com.cyseg.repositorios.EstadoRepositorio;
import com.cyseg.repositorios.RegistroRepositorio;

@Service
public class ResgistroServicio {

	//Instanciamos un objeto del repositorio de registro
	@Autowired
	private RegistroRepositorio registroRepo;
	
	@Autowired
	private EstadoRepositorio estadoRepo;
	
	//metodo para crear un registro nuevo en la base de datos
	public void crearRegistro(String enlace) throws Exception {
		//creamos un objeto vacio de registro
		Registro registro = new Registro();
		
		//validamos si esta vacio el campo
		validarRegistro(enlace);
		
		//creamos un objeto opcional para saber si ya existe una base de datos
		Optional<Registro> resp = registroRepo.findByEnlace(enlace);
		
		if(resp.isPresent()) {
			throw new Exception("El registro ya existe en la base de datos.");
		}else {
			//si no existe en la base de datos lo creamos
			registro.setEnlace(enlace);
			
			//buscamos el estado para pasarlo como defecto
			Estado estado = estadoRepo.findById("1").get();
			registro.setEstado(estado);
			registroRepo.save(registro);
		}
	}
	
	//metoda para cambiar el estado de seguridad de un registro
	public void actualizarEstado(String enlace, String estado) throws Exception {
		//comprobamos si las variables estan vacias
		validarRegistro(enlace);
		validarRegistro(estado);
		
		//creamos un objeto opcional para saber si ya existe una base de datos
		Optional<Registro> resp = registroRepo.findByEnlace(enlace);
		
		//comprobamos que exista en la base de datos
		if(resp.isPresent()) {
			//si existe en la base de datos creamos en un objeto vacio
			Registro registro = resp.get();
			
			//buscamos el estado que corresponda con la busqueda ingresada
			Estado nEstado = estadoRepo.buscarPorEstadoOp(estado).get();
			
			registro.setEstado(nEstado);
			
			registroRepo.save(registro);
		}else {
			//si no existe en la base de datos tiramos mensaje de error
			throw new Exception("El registro no existe en la base de datos");
		}
	}
	
	//metodo para eliminar un registro de la base de datos
	public void eliminarRegistrar(String enlace) throws Exception {
		//comprobamos si las variables estan vacias
		validarRegistro(enlace);
		
		//creamos un objeto opcional para saber si ya existe una base de datos
		Optional<Registro> resp = registroRepo.findByEnlace(enlace);
		
		//comprobamos que exista en la base de datos
		if(resp.isPresent()) {
			Registro registro = resp.get();
			registroRepo.delete(registro);
		}else {
			throw new Exception("No existe en la base de datos");
		}
	}
	
	//metodo para comprobar si la variable esta vacia 
	public void validarRegistro(String enlace) throws Exception {
		if(enlace.isEmpty() || enlace == null) {
			throw new Exception("El campo esta vacio.");
		}
	}
}
