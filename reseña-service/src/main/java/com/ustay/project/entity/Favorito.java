package com.ustay.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;
    private String nombreFavorito; // Por ejemplo, un título o nombre asociado al favorito
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false) // Relación con Persona
    private Persona persona;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "inmueble_id", nullable = false) // Relación con Inmueble
    private Inmueble inmueble;

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public String getNombreFavorito() {
        return nombreFavorito;
    }

    public void setNombreFavorito(String nombreFavorito) {
        this.nombreFavorito = nombreFavorito;
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

    public Favorito() {
    }

    public Favorito(int idFavorito, String nombreFavorito, Persona persona, Inmueble inmueble) {
        this.idFavorito = idFavorito;
        this.nombreFavorito = nombreFavorito;
        this.persona = persona;
        this.inmueble = inmueble;
    }
}
