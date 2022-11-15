package com.cyseg.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyseg.entidades.Registro;
import com.cyseg.servicios.ResgistroServicio;

@Controller
@RequestMapping("/")
public class ControladorPrincipal {
	
	@Autowired
	public ResgistroServicio registroServ;

	@GetMapping("/")
	public String index() {
		//System.out.print("hasta aca llega");
		return "index.html";
	}
	
	@GetMapping("/buscar")
	public String buscar(ModelMap model, @RequestParam(value = "enlace") String enlace) {
		try {
			Registro registro = registroServ.buscarPorEnlace(enlace);
			model.addAttribute("registro", registro);
			if(registro.getEstado().getId().equals("1")) {
				return "seguro.html";
			}else {
				if(registro.getEstado().getId().equals("2")) {
					return "dudoso.html";
				}else {
					if(registro.getEstado().getId().equals("3")){
						return "peligroso.html";
					}else {
						return "dudoso.html";
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "reintentar.html";
	}
}
