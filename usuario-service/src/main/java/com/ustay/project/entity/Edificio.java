package com.ustay.project.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEdificio;
    private String referenciaEdificio;
    private String direccion;
    private String n_pisos;
    private String regla_casa;
    private String imagen;
    private String url_map;

    // Relación muchos a uno con Partner
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    // Relación uno a muchos con Inmueble
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Inmueble> inmuebles;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "zona_id", nullable = false) // Clave foránea que apunta a Zona
    private Zona zona;
    
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
	
    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getReferenciaEdificio() {
        return referenciaEdificio;
    }

    public void setReferenciaEdificio(String referenciaEdificio) {
        this.referenciaEdificio = referenciaEdificio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getN_pisos() {
        return n_pisos;
    }

    public void setN_pisos(String n_pisos) {
        this.n_pisos = n_pisos;
    }

    public String getRegla_casa() {
        return regla_casa;
    }

    public void setRegla_casa(String regla_casa) {
        this.regla_casa = regla_casa;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl_map() {
        return url_map;
    }

    public void setUrl_map(String url_map) {
        this.url_map = url_map;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }

    public Edificio(int idEdificio, String referenciaEdificio, String direccion, String n_pisos, String regla_casa,
            String imagen, String url_map, Partner partner) {
        this.idEdificio = idEdificio;
        this.referenciaEdificio = referenciaEdificio;
        this.direccion = direccion;
        this.n_pisos = n_pisos;
        this.regla_casa = regla_casa;
        this.imagen = imagen;
        this.url_map = url_map;
        this.partner = partner;
    }

    public Edificio() {
        // Constructor vacío
    }
}
