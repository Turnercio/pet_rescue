package com.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Date fechaNac;
	private String raza;
	private float peso;
	private boolean tiene_chip;
	private String url_foto;
	
	
	
	// Se hace que se guarden los nombre en minuscula para que no haya errores por tipografia
	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
}
}