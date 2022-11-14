package com.cyseg.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cyseg.entidades.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, String>{

	//buscamos en la base de datos con una query nativa
	@Query(value= "SELECT e FROM estado e WHERE e.estado = :estado", nativeQuery= true)
	public Optional<Estado> buscarPorEstadoOp(String estado);
	
	/*public Estado buscarPorEstado(String estado);*/
}
