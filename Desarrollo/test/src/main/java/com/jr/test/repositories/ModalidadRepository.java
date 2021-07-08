package com.jr.test.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jr.test.models.Modalidad;

@Repository
public interface ModalidadRepository extends MongoRepository<Modalidad, String> {

}
