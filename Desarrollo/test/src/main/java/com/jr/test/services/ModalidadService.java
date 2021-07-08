package com.jr.test.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
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

import com.jr.test.models.Modalidad;
import com.jr.test.repositories.ModalidadRepository;

@RestController
@CrossOrigin(origins = "*",methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/modalidades")
public class ModalidadService implements CommandLineRunner {
	@Autowired
	ModalidadRepository repository;

	//@PostMapping("/modalidad") 
	public Modalidad create(@Validated @RequestBody Modalidad p) { 
		return repository.insert(p); 
	}
	 
	
	@GetMapping("/")
	public List<Modalidad> readAll(){
		return repository.findAll();
	}
	
	public List<Modalidad> saveAll(List<Modalidad> lista_modalidades){
		return repository.saveAll(lista_modalidades);
	}

	/*
	 * @PutMapping("/modalidad/{id}") public Modalidad update(@PathVariable String
	 * id,@Validated @RequestBody Modalidad p) { return repository.save(p); }
	 */

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.deleteAll();
		if(this.readAll().isEmpty()) {
			Modalidad mod1 = new Modalidad("1","Privado","curso Privado");
			Modalidad mod2 = new Modalidad("2","Online","curso online");
			Modalidad mod3 = new Modalidad("3","OnDemand","curso por demanda");
			
			List<Modalidad> lista_modalidades = Arrays.asList(mod1,mod2,mod3);
			repository.saveAll(lista_modalidades);
		}
	}
}
