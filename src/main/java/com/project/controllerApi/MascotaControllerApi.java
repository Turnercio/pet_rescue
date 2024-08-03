package com.project.controllerApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Mascota;
import com.project.repository.MascotaRepository;

@RestController
@RequestMapping(path = "/api/mascota", produces = "application/json")
public class MascotaControllerApi {

	@Autowired
	private MascotaRepository mascotaRepository;
	
	@GetMapping("/{id}")
	public Mascota getMascotaById(@PathVariable("id") Long id) {
		Optional<Mascota> mascota = mascotaRepository.findById(id);
		if (mascota.isPresent()) {
			return mascota.get();
		}
		return null;
	}
	
    @GetMapping("/nombre/{nombre}")
	public Mascota getMascotaByName(@PathVariable("nombre") String nombre) {
		return mascotaRepository.findByNombre(nombre);
		
	}
    
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Mascota saveMascota(@RequestBody Mascota mascota) {
		Mascota saved = mascotaRepository.save(mascota);
		return saved;
	}
    
	@GetMapping
	public Iterable<Mascota> findAll() {
		return mascotaRepository.findAll();
	}
    }

