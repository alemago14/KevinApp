package com.cyseg.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cyseg.entidades.Registro;

@Repository
//Heredamos todos los metodo de jpa repository para la manipulacion de la BD
public interface RegistroRepositorio extends JpaRepository<Registro, String>{

	//Buscar en la base de datos el registro con un methodQuery que tiene las palabras claves findBy
	Optional<Registro> findByEnlace(String enlace);
	
}
