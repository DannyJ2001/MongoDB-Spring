package com.example.PracticaMongo.Controller;


import com.example.PracticaMongo.Model.Persona;
import com.example.PracticaMongo.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarPersona() {
        try {
            List<Persona> personas = personaService.finfByAll();

            if (personas != null && !personas.isEmpty()) {
                return new ResponseEntity<>(personas, HttpStatus.OK);
            } else {
                // Devuelve una respuesta adecuada cuando la lista es nula o vacía.
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();  // Registra la excepción en los logs.
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona p) {
        return new ResponseEntity<>(personaService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona p) {
        Persona personaEncontrada = personaService.findById(id);
        if (personaEncontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaEncontrada.setNombre(p.getNombre());
                personaEncontrada.setApellido(p.getApellido());
                personaEncontrada.setDireccion(p.getDireccion());
                return new ResponseEntity<>(personaService.save(personaEncontrada), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarPersona(@PathVariable Long id) {
        try {
            personaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataAccessException e) {
            // En caso de un error al eliminar
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}