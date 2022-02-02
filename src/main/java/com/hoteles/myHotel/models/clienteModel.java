package com.hoteles.myHotel.models;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class clienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String identidad;
    private String nombres;
    private Boolean activo;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getId() {
        return this.id;
    }

    public String getIdentidad() {
        return this.identidad;
    }

    public String getNombres() {
        return this.nombres;
    }

    public Boolean getActivo() {
        return this.activo;
    }

}