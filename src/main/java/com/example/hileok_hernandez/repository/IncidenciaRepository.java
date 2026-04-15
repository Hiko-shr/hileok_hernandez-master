package com.example.hileok_hernandez.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.hileok_hernandez.model.Incidencia;

@Repository
public class IncidenciaRepository {

    private List<Incidencia> incidencias = new ArrayList<>();
    private AtomicInteger contador = new AtomicInteger(1);

    // Crear usuario
    public Incidencia crear(Incidencia incidencia) {
        incidencia.setId(contador.getAndIncrement());
        incidencias.add(incidencia);
        return incidencia;
    }

    // Listar todos
    public List<Incidencia> readAll() {
        return incidencias;
    }

    // Buscar por id
    public Optional<Incidencia> findById(int id) {
        return incidencias.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    // Actualizar
    public Incidencia update(int id, Incidencia incidencia) {
        Optional<Incidencia> existente = findById(id);
        if (existente.isPresent()) {
            incidencias.remove(existente.get());
            incidencias.add(incidencia);
            return incidencia;
        }
        return null;
    }

    // Eliminar
    public boolean eliminar(int id) {
        return incidencias.removeIf(u -> u.getId() == id);
    }

    public List<Incidencia> findByEstado(String estado) {
        throw new UnsupportedOperationException("Unimplemented method 'findByEstado'");
    }

}