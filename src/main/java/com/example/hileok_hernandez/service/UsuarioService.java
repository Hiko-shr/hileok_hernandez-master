package com.example.hileok_hernandez.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hileok_hernandez.model.Usuario;
import com.example.hileok_hernandez.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Consultar todas las incidencias almacenadas
    public List<Usuario> readAll() {
        return usuarioRepository.listaUsuarios();
    }

    // Registrar nuevas incidencias
    public Usuario create(Usuario usuario) {
        return usuarioRepository.crearUsuario(usuario);
    }

    // Buscar incidencia por ID
    public Optional<Usuario> findById(int id) {
        return usuarioRepository.findById(id);
    }

    // Buscar incidencias según criterio (ejemplo: por estado)
    public List<Usuario> findByEstado(String estado) {
        return usuarioRepository.findByEstado(estado);
    }

    // Modificar información de incidencias existentes
    public Usuario update(int id, Usuario usuario) {
        return usuarioRepository.update(id, usuario);
    }

    // Eliminar incidencias del sistema
    public boolean eliminar(int id) {
        return usuarioRepository.eliminar(id);
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