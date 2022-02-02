package com.hoteles.myHotel.models;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "dias_festivos")
public class diasFestivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private Date fecha;
    private String descripcion;
    private Boolean activo;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Boolean getActivo() {
        return this.activo;
    }

}
