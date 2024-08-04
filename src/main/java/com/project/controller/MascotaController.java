package com.project.controller;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.Mascota;
import com.project.repository.MascotaRepository;

@Controller
public class MascotaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    @GetMapping("/mascotas")
    public String getAllMascotas(Model model) {
        Iterable<Mascota> mascotas = mascotaRepository.findAll();
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }
    
    public List<Mascota> obtenerMascotasJovenes() {
        // Obtener todas las mascotas y ordenar por fecha de nacimiento
        List<Mascota> mascotas = (List<Mascota>) mascotaRepository.findAll();
        return mascotas.stream()
                .sorted(Comparator.comparing(Mascota::getFechaNac).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }
}