package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.consumoDetalleModel;
import com.hoteles.myHotel.services.consumoDetalleService;

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
@RequestMapping("/consumoDetalles")
public class consumoDetalleController {

    @Autowired
    consumoDetalleService consumoDetalleService;

    @GetMapping()
    public ArrayList<consumoDetalleModel> consumoDetalles() {
        return this.consumoDetalleService.consumoDetalles();
    }

    @GetMapping(path = "/query")
    public ArrayList<consumoDetalleModel> consumoDetallesActivos(@RequestParam("activo") Boolean activo) {
        return this.consumoDetalleService.consumoDetallesActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<consumoDetalleModel> consumoDetallesxId(@PathVariable("id") Integer id) {
        return this.consumoDetalleService.consumoDetallesxId(id);
    }

    @PostMapping()
    public consumoDetalleModel consumoDetallesCrear(@RequestBody consumoDetalleModel consumoDetalle) {
        return this.consumoDetalleService.consumoDetallesCrear(consumoDetalle);
    }

    @PutMapping()
    public consumoDetalleModel consumoDetallesModificar(@RequestBody consumoDetalleModel consumoDetalle) {
        return this.consumoDetalleService.consumoDetallesCrear(consumoDetalle);
    }

}
