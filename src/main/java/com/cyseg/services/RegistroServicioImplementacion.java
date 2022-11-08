package com.cyseg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyseg.enums.Estado;
import com.cyseg.repositories.RegistroRepositorio;

@Service
public class RegistroServicioImplementacion implements RegistroServicio {
	
	@Autowired
	private RegistroRepositorio registroRepo;

	@Override
	public void crearRegistro(String enlace) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarRegistro(Long id, String enlace, Estado estado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarRegistro(Long id, String enlace) {
		// TODO Auto-generated method stub
		
	}

}
