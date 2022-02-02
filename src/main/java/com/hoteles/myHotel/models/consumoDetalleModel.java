package com.hoteles.myHotel.models;

import javax.persistence.*;

@Entity
@Table(name = "consumos_detalle")
public class consumoDetalleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private Integer id_consumo;

    @ManyToOne
    @JoinColumn(name = "id_servicio", nullable = false)
    private servicioModel id_servicio;

    private Float valor;
    private Boolean activo;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId_consumo(Integer id_consumo) {
        this.id_consumo = id_consumo;
    }

    public void setId_servicio(servicioModel id_servicio) {
        this.id_servicio = id_servicio;
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

    public Integer getId_consumo() {
        return this.id_consumo;
    }

    public servicioModel getId_servicio() {
        return this.id_servicio;
    }

    public Float getValor() {
        return this.valor;
    }

    public Boolean getActivo() {
        return this.activo;
    }

}
