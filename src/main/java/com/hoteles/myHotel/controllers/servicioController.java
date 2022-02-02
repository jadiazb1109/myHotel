package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.servicioModel;
import com.hoteles.myHotel.services.servicioService;

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
@RequestMapping("/servicios")
public class servicioController {

    @Autowired
    servicioService servicioService;

    @GetMapping()
    public ArrayList<servicioModel> servicios() {
        return this.servicioService.servicios();
    }

    @GetMapping(path = "/query")
    public ArrayList<servicioModel> serviciosActivos(@RequestParam("activo") Boolean activo) {
        return this.servicioService.serviciosActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<servicioModel> serviciosxId(@PathVariable("id") Integer id) {
        return this.servicioService.serviciosxId(id);
    }

    @PostMapping()
    public servicioModel serviciosCrear(@RequestBody servicioModel servicio) {
        return this.servicioService.serviciosCrear(servicio);
    }

    @PutMapping()
    public servicioModel serviciosModificar(@RequestBody servicioModel servicio) {
        return this.servicioService.serviciosCrear(servicio);
    }

}
