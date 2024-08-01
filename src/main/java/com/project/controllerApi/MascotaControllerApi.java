package com.project.controllerApi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
