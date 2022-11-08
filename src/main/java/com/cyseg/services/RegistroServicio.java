package com.cyseg.services;

import com.cyseg.enums.Estado;

public interface RegistroServicio {

	public void crearRegistro(String enlace);
	public void actualizarRegistro(Long id, String enlace, Estado estado);
	public void eliminarRegistro(Long id, String enlace);
}
