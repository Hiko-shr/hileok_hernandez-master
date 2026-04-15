package com.example.hileok_hernandez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.hileok_hernandez.model.Usuario;
import com.example.hileok_hernandez.service.UsuarioService;

// en el controller se ponen la lista de informaciones con metodos
//validar, crear, eliminar, etc. hasta listar la informacion.
//llama al modelo y al servicio para hacer las operaciones necesarias, como crear, eliminar, etc.

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Crear un nuevo usuario (con validación)
    @PostMapping
    public ResponseEntity<String> postUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario u = usuarioService.create(usuario);
            return ResponseEntity.ok("Usuario agregado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Datos incompletos: " + e.getMessage());
        }
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<?> getUsuarios() {
        List<Usuario> lista = usuarioService.readAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("Recursos no encontrados");
        }
        return ResponseEntity.ok(lista);
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.status(404).body("Usuario no encontrado con id " + id);
    }

    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<String> putUsuario(@PathVariable int id, @Valid @RequestBody Usuario usuario) {
        try {
            Usuario u = usuarioService.update(id, usuario);
            if (u != null) {
                return ResponseEntity.ok("Usuario actualizado correctamente");
            }
            return ResponseEntity.status(404).body("Usuario no encontrado con id " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar: " + e.getMessage());
        }
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
        boolean eliminado = usuarioService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return ResponseEntity.status(404).body("Usuario no encontrado con id " + id);
    }
}