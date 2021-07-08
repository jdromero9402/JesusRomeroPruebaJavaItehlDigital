package com.jr.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jr.test.models.Curso;
import com.jr.test.models.Modalidad;
import com.jr.test.services.CursoService;
import com.jr.test.services.DescuentoService;
import com.jr.test.services.ModalidadService;

@Controller
public class DescuentoController {
	
	@Autowired
	private DescuentoService servicio_descuento;
	
	@Autowired
	private CursoService servicio_curso;
	
	@GetMapping("/crear_descuento/{id_curso}")
	public String crearCurso(Model modelo, @PathVariable String id_curso) {
		Curso curso = servicio_curso.findById(id_curso);
		
		double descuento = 0;
		
		String modalidad = curso.getModalidad();
		
		if(modalidad.equals("Privado")) {
			descuento = 0.1;
		}else if(modalidad.equals("Online")) {
			descuento = 0.2;
		}else if(modalidad.equals("OnDemand")) {
			descuento = 0.3;
		}
		
		double nuevo_costo_curso = curso.getCosto() * descuento;
		curso.setCosto(nuevo_costo_curso);
		String descuento_label = (descuento * 100) + "%";
		
		modelo.addAttribute("curso",curso);
		modelo.addAttribute("descuento",descuento);
		modelo.addAttribute("descuento_label",descuento_label);
		
		return "crear_descuento";
	}
}
