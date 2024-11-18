package com.ustay.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idREseña;
    private String calificacion;
    private String comentario;
    private String fechaReseña;
    private String telefono;
    private String fechaRegistro;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false) // Relación con Persona
    private Persona persona;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "inmueble_id", nullable = false) // Relación con Inmueble
    private Inmueble inmueble;

    public int getIdREseña() {
        return idREseña;
    }

    public void setIdREseña(int idREseña) {
        this.idREseña = idREseña;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaReseña() {
        return fechaReseña;
    }

    public void setFechaReseña(String fechaReseña) {
        this.fechaReseña = fechaReseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Reseña() {
    }

    public Reseña(int idREseña, String calificacion, String comentario, String fechaReseña, String telefono,
                  String fechaRegistro, Persona persona, Inmueble inmueble) {
        this.idREseña = idREseña;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaReseña = fechaReseña;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.persona = persona;
        this.inmueble = inmueble;
    }
}
