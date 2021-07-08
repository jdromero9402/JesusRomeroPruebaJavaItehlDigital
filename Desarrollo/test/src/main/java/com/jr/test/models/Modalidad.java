package com.jr.test.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="modalidades")
public class Modalidad {
	
	private String id;
	
	private String nombre;
	
	private String descripcion;

	public Modalidad(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		descripcion = descripcion;
	}
	
	
}
