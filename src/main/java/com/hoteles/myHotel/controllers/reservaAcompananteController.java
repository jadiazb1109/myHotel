package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.reservaAcompananteModel;
import com.hoteles.myHotel.services.reservaAcompananteService;

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
@RequestMapping("/reservaAcompanantes")
public class reservaAcompananteController {

    @Autowired
    reservaAcompananteService reservaAcompananteService;

    @GetMapping()
    public ArrayList<reservaAcompananteModel> reservaAcompanantes() {
        return this.reservaAcompananteService.reservaAcompanantes();
    }

    @GetMapping(path = "/query")
    public ArrayList<reservaAcompananteModel> reservaAcompanantesActivos(@RequestParam("activo") Boolean activo) {
        return this.reservaAcompananteService.reservaAcompanantesActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<reservaAcompananteModel> reservaAcompanantesxId(@PathVariable("id") Integer id) {
        return this.reservaAcompananteService.reservaAcompanantesxId(id);
    }

    @PostMapping()
    public reservaAcompananteModel reservaAcompanantesCrear(@RequestBody reservaAcompananteModel reservaAcompanante) {
        return this.reservaAcompananteService.reservaAcompanantesCrear(reservaAcompanante);
    }

    @PutMapping()
    public reservaAcompananteModel reservaAcompanantesModificar(
            @RequestBody reservaAcompananteModel reservaAcompanante) {
        return this.reservaAcompananteService.reservaAcompanantesCrear(reservaAcompanante);
    }

}
