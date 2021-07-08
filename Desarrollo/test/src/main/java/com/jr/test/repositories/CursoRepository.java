package com.jr.test.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jr.test.models.Curso;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
	
	public List<Curso> findByModalidad(@Param("modalidad")String modalidad);
}
