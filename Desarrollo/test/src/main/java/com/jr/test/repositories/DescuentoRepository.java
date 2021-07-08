package com.jr.test.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jr.test.models.Descuento;

@Repository
public interface DescuentoRepository extends MongoRepository<Descuento, String> {

}
