package com.example.PracticaMongo.Model;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Persona")
@Data
public class Persona {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private Contactos contactos;
    private List<Telefonia> listTelefonia;

}
