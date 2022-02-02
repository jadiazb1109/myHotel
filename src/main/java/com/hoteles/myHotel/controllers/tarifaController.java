package com.hoteles.myHotel.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.hoteles.myHotel.models.tarifaModel;
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
@RequestMapping("/tarifas")
public class tarifaController {

    @Autowired
    tarifaService tarifaService;

    @GetMapping()
    public ArrayList<tarifaModel> tarifas() {
        return this.tarifaService.tarifas();
    }

    @GetMapping(path = "/query")
    public ArrayList<tarifaModel> tarifasActivos(@RequestParam("activo") Boolean activo) {
        return this.tarifaService.tarifasActivos(activo);
    }

    @GetMapping(path = "/{id}")
    public Optional<tarifaModel> tarifasxId(@PathVariable("id") Integer id) {
        return this.tarifaService.tarifasxId(id);
    }

    @PostMapping()
    public tarifaModel tarifasCrear(@RequestBody tarifaModel tarifa) {
        return this.tarifaService.tarifasCrear(tarifa);
    }

    @PutMapping()
    public tarifaModel tarifasModificar(@RequestBody tarifaModel tarifa) {
        return this.tarifaService.tarifasCrear(tarifa);
    }

}
