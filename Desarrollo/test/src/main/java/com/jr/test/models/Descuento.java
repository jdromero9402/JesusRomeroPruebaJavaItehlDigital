package com.jr.test.models;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "descuentos")
public class Descuento {
	
	private String id;
	
	private String nombre;
	
	private String modalidad;
	
	private String pais;
	
	private double descuento;
	
	private String id_curso;
	
	private LocalDate fecha_final;

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

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getId_curso() {
		return id_curso;
	}

	public void setId_curso(String id_curso) {
		this.id_curso = id_curso;
	}

	public LocalDate getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(LocalDate fecha_final) {
		this.fecha_final = fecha_final;
	}
}
