package com.hoteles.myHotel.models;

import javax.persistence.*;

@Entity
@Table(name = "reservas_acompanastes")
public class reservaAcompananteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private Integer id_reserva;
    private String nombres;
    private Boolean activo;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
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

    public Integer getId_reserva() {
        return this.id_reserva;
    }

    public String getNombres() {
        return this.nombres;
    }

    public Boolean getActivo() {
        return this.activo;
    }

}
