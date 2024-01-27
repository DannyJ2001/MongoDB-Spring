package com.example.PracticaMongo.Repository;

import com.example.PracticaMongo.Model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, Long> {

}
