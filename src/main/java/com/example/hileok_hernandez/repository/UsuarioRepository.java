package com.example.hileok_hernandez.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.hileok_hernandez.model.Usuario;

//agregar la lista de informacion, metodos de crear, eliminar, etc.

public class UsuarioRepository {

    public List<Usuario> usuarios = new ArrayList<>();

    public Usuario crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    //ordenar incidencias
    public List<Usuario> listaUsuarios() {
        return usuarios;
    }

    //realizar busquedas especificas


    //generar subconjuntos de infomracion


    public boolean eliminar(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }

    public List<Usuario> findByEstado(String estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEstado'");
    }

    public Usuario update(int id, Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public Optional<Usuario> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}

//public List<Persona> personas = new ArrayList<>();
//    public List<Persona> listaPersonas() {
//        return personas;
//    }
//
//    public Persona crearPersona(Persona persona) {
//        personas.add(persona);
//        return persona;
//        
//    }

//eliminar
//    public boolean eliminar(int id) {
//        return personas.removeIf(p -> p.getId() == id);
//    }