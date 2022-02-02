package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.consumoModel;
import com.hoteles.myHotel.services.consumoService;

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
@RequestMapping("/consumos")
public class consumoController {

    @Autowired
    consumoService consumoService;

    @GetMapping()
    public ArrayList<consumoModel> consumos() {
        return this.consumoService.consumos();
    }

    @GetMapping(path = "/query")
    public ArrayList<consumoModel> consumosActivos(@RequestParam("activo") Boolean activo) {
        return this.consumoService.consumosActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<consumoModel> consumosxId(@PathVariable("id") Integer id) {
        return this.consumoService.consumosxId(id);
    }

    @PostMapping()
    public consumoModel consumosCrear(@RequestBody consumoModel consumo) {
        return this.consumoService.consumosCrear(consumo);
    }

    @PutMapping()
    public consumoModel consumosModificar(@RequestBody consumoModel consumo) {
        return this.consumoService.consumosCrear(consumo);
    }

}
