package com.hoteles.myHotel.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "reservas")
public class reservaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    private Date fecha;
    private Date fecha_ingreso;
    private Date fecha_salida;
    private Boolean todo_incluido;
    private Float valor_todo_incluido;
    private Float total;
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private clienteModel id_cliente;

    @OneToMany(mappedBy = "id_reserva")
    private Set<reservaAcompananteModel> acompanantes;

    @OneToMany(mappedBy = "id_reserva")
    private Set<consumoModel> consumos;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setId_cliente(clienteModel id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setTodo_incluido(Boolean todo_incluido) {
        this.todo_incluido = todo_incluido;
    }

    public void setValor_todo_incluido(Float valor_todo_incluido) {
        this.valor_todo_incluido = valor_todo_incluido;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void setAcompanantes(Set<reservaAcompananteModel> acompanantes) {
        this.acompanantes = acompanantes;
    }

    public void setConsumos(Set<consumoModel> consumos) {
        this.consumos = consumos;
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

    public clienteModel getId_cliente() {
        return this.id_cliente;
    }

    public Date getFecha_ingreso() {
        return this.fecha_ingreso;
    }

    public Date getFecha_salida() {
        return this.fecha_salida;
    }

    public Boolean getTodo_incluido() {
        return this.todo_incluido;
    }

    public Float getValor_todo_incluido() {
        return this.valor_todo_incluido;
    }

    public Float getTotal() {
        return this.total;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public Set<reservaAcompananteModel> getAcompanantes() {
        return this.acompanantes;
    }

    public Set<consumoModel> getConsumos() {
        return this.consumos;
    }

}
