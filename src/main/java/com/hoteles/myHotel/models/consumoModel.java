package com.hoteles.myHotel.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "consumos")
public class consumoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private Date fecha;
    private Integer id_reserva;
    private Boolean activo;

    @OneToMany(mappedBy = "id_consumo")
    private Set<consumoDetalleModel> servicios;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setServicios(Set<consumoDetalleModel> servicios) {
        this.servicios = servicios;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public Integer getId_reserva() {
        return this.id_reserva;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public Set<consumoDetalleModel> getServicios() {
        return this.servicios;
    }

}