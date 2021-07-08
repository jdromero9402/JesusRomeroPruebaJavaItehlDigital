package com.jr.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jr.test.models.Curso;
import com.jr.test.models.Modalidad;
import com.jr.test.repositories.CursoRepository;
import com.jr.test.repositories.ModalidadRepository;

@RestController
@CrossOrigin(origins = "*",methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
@RequestMapping("/api/cursos")
public class CursoService {
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private ModalidadRepository modal_repository;
	
	@PostMapping("/curso")
	public Curso create(@Validated @RequestBody Curso p) {
		return repository.insert(p);
	}
	
	@GetMapping("/")
	public List<Curso> readAll(){
		return repository.findAll();
	}
	
	@GetMapping("/curso/modalidad/{id}")
	public List<Curso> readAllByModalidad(@PathVariable String modalidad_id_in){
		//List<Curso> cursos = repository.findAll();
		List<Curso> cursos = repository.findByModalidad(modalidad_id_in);
		Curso curso;
		String modalidad_id;
		String modalidad_nombre;
		for(int i = 0;i<cursos.size();i++) {
			curso =cursos.get(i);
			modalidad_id = curso.getModalidad();
			if(modalidad_id != null) {
				modalidad_nombre = modal_repository.findById(modalidad_id).get().getNombre();
				curso.setModalidad(modalidad_nombre);
			}
			
		}
		return cursos;
	}
	
	@PutMapping("/curso/{id}")
	public Curso update(@PathVariable String id,@Validated @RequestBody Curso p) {
		return repository.save(p);
	}
	
	@GetMapping("/curso/find/{id}")
	public Curso findById(@PathVariable String id_curso){
		//List<Curso> cursos = repository.findAll();
		//List<Curso> cursos = repository.findByModalidad(modalidad_id_in);
		Curso curso = repository.findById(id_curso).get();
		String modalidad_id;
		String modalidad_nombre;
		modalidad_id = curso.getModalidad();
		if(modalidad_id != null) {
			modalidad_nombre = modal_repository.findById(modalidad_id).get().getNombre();
			curso.setModalidad(modalidad_nombre);
		}
		
		return curso;
	}
	
	@GetMapping("/curso/findModel/{id}")
	public Curso findModelById(@PathVariable String id_curso){
		//List<Curso> cursos = repository.findAll();
		//List<Curso> cursos = repository.findByModalidad(modalidad_id_in);
		Curso curso = repository.findById(id_curso).get();
		
		return curso;
	}
	

}
