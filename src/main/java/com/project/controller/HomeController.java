package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/lista-jovenes")
    public String listaJovenes() {
    	return "lista-jovenes";
    }
    
    @GetMapping("/busca-mascota")
    public String añadirMascota() {
    	return "busca-mascota";
    }
    
    @GetMapping("/crear-mascota")
    public String crearMascota() {
    	return "crear-mascota";
    }
    
    @GetMapping("/eliminar-mascota")
    public String eliminarMascota() {
    	return "eliminar-mascota";
    }
}
