package com.example.PracticaMongo.Service;


import com.example.PracticaMongo.Model.Persona;
import com.example.PracticaMongo.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public CrudRepository<Persona,Long> getDao(){
        return personaRepository;
    }





}