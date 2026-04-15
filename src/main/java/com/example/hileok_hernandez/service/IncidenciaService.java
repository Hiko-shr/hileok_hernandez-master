package com.example.hileok_hernandez.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hileok_hernandez.model.Incidencia;
import com.example.hileok_hernandez.repository.IncidenciaRepository;

@Service
public class IncidenciaService {
    @Autowired
    private IncidenciaRepository IncidenciaRepository;

    // Registrar nuevas incidencias
    public Incidencia create(Incidencia incidencia) {
        return IncidenciaRepository.crear(incidencia);
    }

    // Consultar todas las incidencias almacenadas
    public List<Incidencia> readAll() {
        return IncidenciaRepository.readAll();
    }

    // Buscar incidencia por ID
    public Optional<Incidencia> findById(int id) {
        return IncidenciaRepository.findById(id);
    }

    // Buscar incidencias según criterio (ejemplo: por estado)
    
    public List<Incidencia> findByEstado(String estado) {
        return IncidenciaRepository.findByEstado(estado);
    }
    // Modificar información de incidencias existentes
    public Incidencia update(int id, Incidencia incidencia) {
        return IncidenciaRepository.update(id, incidencia);
    }

    // Eliminar incidencias del sistema
    public boolean eliminar(int id) {
        return IncidenciaRepository.eliminar(id);
    }
}


//Registrar nuevas incidencias
//• Registrar nuevas incidencias
//• Consultar las incidencias almacenadas
//• Buscar incidencias según algún criterio relevante
//• Modificar información de incidencias existentes
//• Eliminar incidencias del sistema


//el service sirve para poner la lista, en crear, hasta eliminar.
//llama al repositorio y guarda la informacion


//@Autowired
//    private PersonaRepository personaRepository;
//
//    public List<Persona> readAll() {
//        return personaRepository.listaPersonas();
//    }
//    public Persona create(Persona persona) {
//        return personaRepository.crearPersona(persona);
//    }

//eliminar
//public boolean eliminar(int id) {
//    return personaRepository.eliminar(id);
//    }