package com.cyseg.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControladorPrincipal {

	@GetMapping("/")
	public String index() {
		System.out.print("hasta aca llega");
		return "index.html";
	}
}
