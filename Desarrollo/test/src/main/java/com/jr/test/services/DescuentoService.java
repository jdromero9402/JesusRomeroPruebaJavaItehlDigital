package com.jr.test.services;

import java.util.List;

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
import com.jr.test.models.Descuento;
import com.jr.test.repositories.CursoRepository;
import com.jr.test.repositories.DescuentoRepository;

@RestController
@CrossOrigin(origins = "*",methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT})
@RequestMapping("/api/descuentos")
public class DescuentoService {
	@Autowired
	private DescuentoRepository repository;
	
	@Autowired
	private CursoRepository curso_repository;
	
	@PostMapping("/descuento")
	public Descuento create(@Validated @RequestBody Descuento p) {
		Curso curso = curso_repository.findById(p.getId_curso()).get();
		curso.setHas_discount(true);
		double costo = curso.getCosto();
		curso.setCosto(costo - (costo * p.getDescuento()));
		curso_repository.save(curso);
		return repository.insert(p);
	}
	
	@GetMapping("/")
	public List<Descuento> readAll(){
		return repository.findAll();
	}
	
	@PutMapping("/descuento/{id}")
	public Descuento update(@PathVariable String id,@Validated @RequestBody Descuento p) {
		return repository.save(p);
	}
}
