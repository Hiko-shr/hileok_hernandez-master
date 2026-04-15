package com.example.hileok_hernandez.model;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// se les agrega la informacion necesaria en el modelo como nombre, edad, etc. 
// la validacion se hace con anotaciones, como @NotBlank, @Size, etc. para validar la informacion que se ingresa.

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private static final AtomicInteger contador = new AtomicInteger(1);

    private int id;

    // Nombre del usuario
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    // Apellido del usuario
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    
    //descripcion del problema
    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 10, max = 200, message = "La descripcion debe tener entre 10 y 200 caracteres")
    private String descripcion;

    //estado de la incidencia
    @NotBlank(message = "El estado es obligatorio")
    @Size(min = 2, max = 20, message = "El estado debe tener entre 2 y 20 caracteres")
    private String estado;

    //nivel de prioridad
    @Min(value = 1, message = "La prioridad debe ser al menos 1")
    @Max(value = 5, message = "La prioridad debe ser como máximo 5")
    private int prioridad;

    //usuario que reporta la incidencia
    @NotBlank(message = "El usuario es obligatorio")
    @Size(min = 2, max = 50, message = "El usuario debe tener entre 2 y 50 caracteres")
    private String usuario;

    //fecha de reporte
    @NotBlank(message = "La fecha de reporte es obligatoria")
    @Size(min = 10, max = 10, message = "La fecha de reporte debe tener el formato YYYY-MM-DD")
    private String fechaReporte;

    public Usuario(String nombre, String apellido, int edad, String descripcion, String estado, int prioridad, String usuario, String fechaReporte) {
        this.id = contador.getAndIncrement();
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.usuario = usuario;
        this.fechaReporte = fechaReporte;
    }
}


//Atributos relevantes para el contexto del problema
//• Atributos relevantes para el contexto del problema
//• Tipos de datos adecuados
//• Identificadores únicos
//• Estructuras que permitan gestionar múltiples incidencias



