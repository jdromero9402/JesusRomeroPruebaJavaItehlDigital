package com.jr.test.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cursos")
public class Curso {
	
	private String id;
	
	private String nombre;
	
	private String descripcion;
	
	private String dirigido_a;
	
	private double costo;
	
	private String modalidad;
	
	private Integer horas;
	
	private Boolean has_discount = false;
	
	public Boolean getHas_discount() {
		return has_discount;
	}

	public void setHas_discount(Boolean has_discount) {
		this.has_discount = has_discount;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
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
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDirigido_a() {
		return dirigido_a;
	}

	public void setDirigido_a(String dirigido_a) {
		this.dirigido_a = dirigido_a;
	}

}
