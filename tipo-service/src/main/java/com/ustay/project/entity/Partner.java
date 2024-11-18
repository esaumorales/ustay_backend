package com.ustay.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String direccion;
    private String correo_empresa;
    private String telefono_empresa;
    private String dni;
    private String img;
    private String img2;

    @OneToMany(mappedBy = "partner")
    @JsonIgnore
    private List<Edificio> edificio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false) // Relación con Persona
    private Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo_empresa() {
        return correo_empresa;
    }

    public void setCorreo_empresa(String correo_empresa) {
        this.correo_empresa = correo_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public List<Edificio> getEdificio() {
        return edificio;
    }

    public void setEdificio(List<Edificio> edificio) {
        this.edificio = edificio;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Partner(int id, String direccion, String correo_empresa, String telefono_empresa, String dni, String img,
            String img2, List<Edificio> edificio, Persona persona) {
        this.id = id;
        this.direccion = direccion;
        this.correo_empresa = correo_empresa;
        this.telefono_empresa = telefono_empresa;
        this.dni = dni;
        this.img = img;
        this.img2 = img2;
        this.edificio = edificio;
        this.persona = persona;
    }

    public Partner() {
    }
}
