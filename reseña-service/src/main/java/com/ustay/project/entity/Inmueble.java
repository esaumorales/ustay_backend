package com.ustay.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Inmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private boolean disponibilidad;
    private double precio;
    private int n_cuarto;
    private boolean ilove;

    @JsonIgnore
    @ManyToOne
    private Edificio edificio;

    @OneToMany(mappedBy = "inmueble")
    @JsonIgnore
    private List<Servicios> servicio;

    @OneToMany(mappedBy = "inmueble")
    @JsonIgnore
    private List<Especificaciones> especificacion;

    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false) // Clave foránea que apunta a Tipo
    private Tipo tipo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "periodo_id", nullable = false) // Clave foránea que apunta a Periodo
    private Periodo periodo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getN_cuarto() {
        return n_cuarto;
    }

    public void setN_cuarto(int n_cuarto) {
        this.n_cuarto = n_cuarto;
    }

    public boolean isIlove() {
        return ilove;
    }

    public void setIlove(boolean ilove) {
        this.ilove = ilove;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public List<Servicios> getServicio() {
        return servicio;
    }

    public void setServicio(List<Servicios> servicio) {
        this.servicio = servicio;
    }

    public List<Especificaciones> getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(List<Especificaciones> especificacion) {
        this.especificacion = especificacion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Inmueble() {
    }

    public Inmueble(int id, String descripcion, boolean disponibilidad, double precio, int n_cuarto, boolean ilove,
                    Edificio edificio, Tipo tipo, Periodo periodo) {
        this.id = id;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
        this.n_cuarto = n_cuarto;
        this.ilove = ilove;
        this.edificio = edificio;
        this.tipo = tipo;
        this.periodo = periodo;
    }
}
