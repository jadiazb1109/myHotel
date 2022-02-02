package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import com.hoteles.myHotel.models.consumoDetalleModel;
import com.hoteles.myHotel.models.consumoModel;
import com.hoteles.myHotel.models.diasFestivoModel;
import com.hoteles.myHotel.models.reservaModel;
import com.hoteles.myHotel.models.tarifaModel;
import com.hoteles.myHotel.services.diasFestivoService;
import com.hoteles.myHotel.services.reservaService;
import com.hoteles.myHotel.services.tarifaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class reservaController {

    @Autowired
    reservaService reservaService;

    @Autowired
    tarifaService tarifaService;

    @Autowired
    diasFestivoService diasFestivoService;

    Optional<reservaModel> reservaModel;

    @GetMapping()
    public ArrayList<reservaModel> reservas() {
        return this.reservaService.reservas();
    }

    @GetMapping(path = "/query")
    public ArrayList<reservaModel> reservasActivos(@RequestParam("activo") Boolean activo) {
        return this.reservaService.reservasActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<reservaModel> reservasxId(@PathVariable("id") Integer id) {
        return this.reservaService.reservasxId(id);
    }

    @PostMapping()
    public reservaModel reservasCrear(@RequestBody reservaModel reserva) {
        return this.reservaService.reservasCrear(reserva);
    }

    @PutMapping()
    public reservaModel reservasModificar(@RequestBody reservaModel reserva) {
        return this.reservaService.reservasCrear(reserva);
    }

    @GetMapping("/{id}/checkout")
    public Optional<reservaModel> reservasCheckout(@PathVariable("id") Integer id) {

        reservaModel = this.reservaService.reservasxId(id);

        // reservaModel.get().setFecha_salida(new Date());
        // se actualiza la fecha de salida para calcular los dias de instancia
        // this.reservaService.reservasCrear(reservaModel.get());

        Float dTotal = 0f;
        Float dServicios = 0f;

        Integer dNumAcompa = reservaModel.get().getAcompanantes().size() + 1;

        // verificamos el consumo de la reserva
        if (reservaModel.get().getTodo_incluido()) {
            dTotal = reservaModel.get().getValor_todo_incluido() * dNumAcompa;
        } else {
            for (consumoModel consumo : reservaModel.get().getConsumos()) {

                for (consumoDetalleModel servicio : consumo.getServicios()) {
                    dTotal = dTotal + servicio.getValor();
                }
            }
        }

        // verificamos el valor de la estadia
        Date vFechaIngreso = reservaModel.get().getFecha_ingreso();
        Date vFechaSalida = reservaModel.get().getFecha_salida();

        long NumDias = (vFechaSalida.getTime() - vFechaIngreso.getTime()) / (3600000 * 24);

        dServicios = dTotal;
        System.out.println("Servicios: " + dServicios);

        for (int i = 0; i < NumDias; i++) {
            diasFestivoModel diasFestivoModel = this.diasFestivoService.diasFestivosFecha(vFechaIngreso);
            Integer diaSemana = vFechaIngreso.getDay();
            tarifaModel tarifaModel = this.tarifaService.tarifasDiaSemana(diaSemana);

            if (diasFestivoModel != null) {
                tarifaModel = this.tarifaService.tarifasDiaSemana(0);
            }
            if (tarifaModel != null) {
                dTotal = dTotal + (tarifaModel.getValor() * dNumAcompa);
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(vFechaIngreso);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            vFechaIngreso = calendar.getTime();

        }
        System.out.println("Estadia de " + dNumAcompa + " personas: " + (dTotal - dServicios));
        System.out.println("Servicios + Estadia:" + dTotal);

        reservaModel.get().setTotal(dTotal);
        // Se actualiza el valor total de la reserva con los consumos y valor de estadia
        // this.reservaService.reservasCrear(reservaModel.get());

        return reservaModel;
    }

}
