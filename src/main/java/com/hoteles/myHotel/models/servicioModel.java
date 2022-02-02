package com.hoteles.myHotel.models;

import javax.persistence.*;

@Entity
@Table(name = "servicios")
public class servicioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private String descripcion;
    private Float valor;
    private Boolean activo;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Float getValor() {
        return this.valor;
    }

    public Boolean getActivo() {
        return this.activo;
    }

}
