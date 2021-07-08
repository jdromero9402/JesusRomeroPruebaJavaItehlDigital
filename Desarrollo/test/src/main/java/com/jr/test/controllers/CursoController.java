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
import com.jr.test.services.ModalidadService;

@Controller
public class CursoController {
	
	@Autowired
	private ModalidadService servicio_modalidad;
	
	@Autowired
	private CursoService servicio_curso;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/crear_curso")
	public String crearCurso(Model modelo) {
		List<Modalidad> modalidades = servicio_modalidad.readAll();
		modelo.addAttribute("modalidades",modalidades);
		return "crear_curso";
	}
	
	@GetMapping("/consultar_cursos/{id_modalidad}")
	public String consultarCursos(Model modelo, @PathVariable String id_modalidad) {
		List<Curso> cursos = servicio_curso.readAllByModalidad(id_modalidad);
		modelo.addAttribute("cursos",cursos);
		return "consultar_cursos";
	}
	
	@GetMapping("/consultar_todos")
	public String consultarTodos(Model modelo) {
		List<Curso> cursos = servicio_curso.readAll();
		modelo.addAttribute("cursos",cursos);
		return "consultar_cursos";
	}
	
	@GetMapping("/consultar")
	public String consultar() {
		return "consultar";
	}
	
	@GetMapping("/consultar_curso/{id_curso}")
	public String consultarCurso(Model modelo, @PathVariable String id_curso) {
		Curso curso = servicio_curso.findModelById(id_curso);
		List<Modalidad> modalidades = servicio_modalidad.readAll();
		modelo.addAttribute("modalidades",modalidades);
		modelo.addAttribute("curso",curso);
		return "consultar_curso";
	}
}
